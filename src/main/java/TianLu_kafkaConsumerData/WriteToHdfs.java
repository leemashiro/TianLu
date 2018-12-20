package TianLu_kafkaConsumerData;

import TianLu_ProductionData.TimeFormat;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;

/**
 * 这里是kafka消费到HDFS的工具类
 */

public class WriteToHdfs {
    public static void toHdfs(KafkaConsumer<String, String> consumer, FileSystem fs) {
        //文件名拼接
        String path = "/TianLi.txt";
        String substring = path.substring(0, 7);
        String time = TimeFormat.nowTime();
        String substring1 = time.substring(0, 10);
        String substring2 = path.substring(7, 11);
        String fileName = substring + "-" + substring1 + substring2;
        FSDataOutputStream dos = null;
        try {
            dos = fs.create(new Path(fileName), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ConsumerRecords<String, String> poll = consumer.poll(1000);
        Iterator<ConsumerRecord<String, String>> iterator = poll.iterator();
        while (true) {
            while (iterator.hasNext()) {
                ConsumerRecord<String, String> next = iterator.next();
                //打印控制台 看看数据过来了吗
                System.out.println("topic:" + next.topic() + "\t分区:" + next.partition() + "\tkey:" + next.key() + "\tvalue:" + next.value());

                //打印kafka value的数据
                try {
                    //创建使用默认大小的缓冲字符输出流
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(dos, "utf-8"));
                    bufferedWriter.write(next.value() + "\n");
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}