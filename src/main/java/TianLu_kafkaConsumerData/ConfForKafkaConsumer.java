package TianLu_kafkaConsumerData;

import java.util.Properties;

public class ConfForKafkaConsumer {
    public static Properties conf(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "hadoop102:6667");
        //每个消费者分配独立的组号
        props.put("group.id", "tll1");
        //如果value合法，则自动提交偏移量
        props.put("enable.auto.commit", "true");
        //设置多久一次更新被消费消息的偏移量
//        props.put("auto.commit.interval.ms", "1000");
        //设置会话响应的时间，超过这个时间kafka可以选择放弃消费或者消费下一条消息
//        props.put("session.timeout.ms", "30000");
        //反序列化
        props.put("auto.offset.reset","earliest");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }
}