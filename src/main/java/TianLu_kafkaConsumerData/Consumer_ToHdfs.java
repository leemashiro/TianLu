package TianLu_kafkaConsumerData;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.net.URI;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class Consumer_ToHdfs {
    public static void main(String[] args){
       //指定HDFS地址
        FileSystem fs = null;
        try {
            fs = FileSystem.get(new URI("hdfs://192.168.1.101:8020"), new Configuration(), "root");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //新建kafka消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(ConfForKafkaConsumer.conf());
        ArrayList<String> topics = new ArrayList();
        //指定topic名
        topics.add("TianLuOffLine");
        //消费订阅 topic
        consumer.subscribe(topics);
        //使用KafkaToHdfs
        WriteToHdfs.toHdfs(consumer,fs);
    }
}
