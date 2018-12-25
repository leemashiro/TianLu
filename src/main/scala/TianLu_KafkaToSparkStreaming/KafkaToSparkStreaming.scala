package TianLu_KafkaToSparkStreaming

import java.util.Date

import TianLu_SparkStreamingToMysql.ConnectPoolUtil
import kafka.utils.ZkUtils
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory, Table}
import org.apache.kafka.common.security.JaasUtils
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.json4s.DefaultFormats
import org.json4s._
import org.json4s.jackson.JsonMethods._

object KafkaToSparkStreaming extends App {
  val sc =new SparkContext(new SparkConf().setMaster("local[*]").setAppName("KafkaToSparkstreaming"))
  sc.setLogLevel("warn")
  val ssc = new StreamingContext(sc,Seconds(5))
  //kafka直流模式   设置kafka连接  offset维护模式等
  val kafkaParams = Map[String, Object](
    "bootstrap.servers" -> "hadoop102:6667",
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer],
    "group.id" -> "tianlu111111111111111111111",
    "auto.offset.reset" -> "earliest",                  //latest
    "enable.auto.commit" -> (false: java.lang.Boolean))

  val topics = Array("TianLu5.0")
  val startPath = "/broker/xt-test/ag"
  val zkUtils = ZkUtils("192.168.1.101:2181",30000,30000,JaasUtils.isZkSecurityEnabled)
  val kafkaStreaming = KafkaUtils.createDirectStream[String,String](
    ssc,
    LocationStrategies.PreferBrokers,
    ConsumerStrategies.Subscribe[String,String](topics,kafkaParams))

  //  hbase的相关配置
  var zookeeperservers = "master:2181,slave1:2181,slave2:2181"
  var tablename = "dengtianlu"

  val hbaseconf: Configuration = HBaseConfiguration.create()
  hbaseconf.set("hbase.zookeeper.quorum",zookeeperservers)
  hbaseconf.set("hbase.zookeeper.property.clientPort", "2181")

  var table: Table = _

  //"detector_x":"500.000"
  case class log(dSampleDate:String, detector_id:String, detector_x:String,  dielectric_constant:String,electrode_current:String)


  kafkaStreaming.map(record => record.value)
      .map(value => {
        //  隐式转换，使用json4s的默认转化器
        implicit val formats: DefaultFormats.type = DefaultFormats
        val json = parse(value)
        // 样式类从JSON对象中提取值
        json.extract[log]
      }).foreachRDD(rdd =>{
            rdd.foreachPartition(partitionOfRecords => {
              partitionOfRecords.foreach(logData => {
                val conn = ConnectPoolUtil.getConnection
//                println(conn)
                conn.setAutoCommit(false) //设为手动提交
                val  stmt = conn.createStatement()
                println(logData.electrode_current)

                      if(logData.electrode_current.equals("Null")||logData.electrode_current.toInt<(20)){
                        stmt.addBatch("insert into result(Abnormal_electrode)values('" +1+"')")
                      }else{
                        stmt.addBatch("insert into result(Abnormal_electrode)values('" +0+"')")
                      }
                stmt.executeBatch()
                conn.commit()
                conn.close()

                })
            })
      }

  )


  ssc.start()
  ssc.awaitTermination()
}