package com.neosoft.employee.kafka;


import com.neosoft.employee.entity.Employee;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import java.util.Properties;
import java.util.concurrent.ExecutionException;


public class EmployeeProducer extends Thread {

    private final String message;
    private final String topic;
    @Value("${kafka.server_url}")
    private String kafkaUrl;
    @Value("${kafka.server_port}")
    private String kafkaPort;
    @Value("${client.id}")
    private String clientId;

    private Producer producer;


    public EmployeeProducer(String topic, String message) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", kafkaUrl + ":" + kafkaPort);
        properties.put("client.id", clientId);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer=new org.apache.kafka.clients.producer.KafkaProducer<>(properties);
        this.message = message;
        this.topic = topic;
    }
    public void run(){
        int messageNo = 1;
        while (true) {
            String messageStr = "Message_" + messageNo;
            long startTime = System.currentTimeMillis();
                try {
                    producer.send(new ProducerRecord<>(topic, messageNo, messageStr)).get();
                    System.out.println("Sent message: (" + messageNo + ", " + messageStr + ")");
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            ++messageNo;
        }
    }
}

