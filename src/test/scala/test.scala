import org.apache.spark
import org.apache.spark.{SparkConf, SparkContext}

object test extends App {
    val sc =new SparkContext(new SparkConf().setAppName("Spark-Hive").setMaster("local[*]"))
    sc.setLogLevel("warn")
//    val ssc = new StreamingContext(sc,Seconds(5))
//    spark.read.json("/opt/tianlu/data.txt")
//    val conf=new SparkConf().setAppName("Spark-Hive").setMaster("local[*]")
//    val ssc=new SparkContext(sc)

    val sqlContext = new org.apache.spark.sql.hive.HiveContext(sc)
    sqlContext.sql("show databases").show()
    sqlContext.sql("use dengtl")
    sqlContext.sql("select * from fixed_parameter_table limit 10").show()
    val conf = new SparkConf().setAppName("SparkSQL Demo")
//    val sc = new SparkContext(conf)
    //  // 屏蔽不必要的日志 ,在终端上显示需要的日志
    //  Logger.getLogger("org.apache.spark").setLevel(Level.OFF)
    //  Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
    //  Logger.getLogger("org.apache.kafka.clients.consumer").setLevel(Level.OFF)

    //  //初始化sparkStreaming
    //  val conf = new SparkConf().setAppName("SaveDataToMysql").setMaster("local[*]")
    //  val sc = new SparkContext(conf)
    //  val ssc = new StreamingContext(sc, Seconds(10))



    //设置连接Kafka的配置信息
    //  val zkQuorum  = "hadoop102:6667"    //zookeeper集群的IP：port，IP：port，IP：port
    //  val group = "testgroup"                //在consumer.properties配置group.id
    //  val topics = "TianLu5.0"               //选择要连接的topic
    //
    //  val numThreads = 2                    //线程

    //这个是有可能有好几个topic同时提供数据，那么我们要把它用空格分割开，然后映射成(topic,2),再转换成map集合
    //  val topicpMap = topics.split("\n").map((_,numThreads.toInt)).toMap

    //  ssc.checkpoint("D:\\shuju\\cherkpoint")
    //  val lines  = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](ssc, kafkaParams, topicsSet)   //创建流
}
