package TianLu_HiveForSparkSQL

import java.util.Properties

import TianLu_SparkStreamingToMysql.ConnectPoolUtil
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.immutable.Map.Map1
import scala.collection.mutable.Map
import scala.xml.XML

object HiveForSparkSQL extends App {
  val spark = SparkSession.builder().master("local[*]").enableHiveSupport().getOrCreate()
  spark.sparkContext.setLogLevel("warn")
//  spark.sql("select * from dengtl.fixed_parameter_table limit 10").show()

  //创建一个Map集合   使用XML.load解析xml文件  然后找到文件头返回一个集合.
  //遍历这个集合  获取全部SQL语句依次执行
  //这个tablename不能相同  不然就只执行最后一条SQL
  var sqls:Map[String,String] = Map();
  val xml= XML.load(this.getClass.getResource("TianLu_HQL.xml"))
  val user= xml \\ "summary"  //获取summary中所有子节点，返回一个集合


//  val conn = ConnectPoolUtil.getConnection
//  val stmt = conn.createStatement()

  user.foreach(f =>{
    val key = f.attribute("tablename").get.text
    var value = f.text
    sqls.put(key,value)
  })
  println(sqls)
  sqls.foreach(f => {
    spark.sql(f._2).write.format("jdbc")
      .option("url","jdbc:mysql://hadoop101:3306/tianluresult")
      .option("dbtable","result1")
      .option("user","root")
      .option("password","root").mode("overwrite").save()
//    stmt.addBatch("insert into result(result) values ('"+result+ "')")
  })


  //stmt.addBatch()

//  print(sqls)
//  sqls.foreach(f => {
//    spark.sql(f._2)
//      .show()
//    //       .write.mode("append").jdbc(Mysql_Utils.URL,f._1,Mysql_Utils.pro)
//  })
}