package TianLu_KafkaToSparkSQL

import org.apache.spark.sql.SparkSession
import scala.collection.mutable.Map

import scala.xml.XML

object KafkaToSparkSQL extends App {
  val spark = SparkSession.builder().master("local[*]").enableHiveSupport().getOrCreate()
  spark.sparkContext.setLogLevel("warn")
//  spark.sql("use dengtl")
//  spark.sql("show tables")
//  spark.sql("select * from fixed_parameter_table limit 10").show()


  val sqls:Map[String,String] = Map();

  val xml= XML.load(this.getClass.getResource("TianLu_HQL.xml"))

  val user= xml \\ "summary"  //获取summary中所有子节点，返回一个集合

  user.foreach(f =>{
    val key = f.attribute("tablename").get.text
    var value = f.text
    sqls.put(key,value)
  })
  print(sqls)
  sqls.foreach(f => {
    spark.sql(f._2)
      .show()
    //       .write.mode("append").jdbc(Mysql_Utils.URL,f._1,Mysql_Utils.pro)
  })
}

