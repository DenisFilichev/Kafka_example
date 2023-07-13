package com.example.producer;

import com.example.dto.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SenderService {

    private final KafkaTemplate<String, Object> kafka;
    private final StringCallbackListener stringCallbackListener;

    @Autowired
    public SenderService(KafkaTemplate<String, Object> kafka, StringCallbackListener stringCallbackListener) {
        this.kafka = kafka;
        this.stringCallbackListener = stringCallbackListener;
    }

    public void send(String message){
        JsonMessage jsonMessage = JsonMessage.builder()
                .number(new Random().nextLong())
                .message(message)
                .build();
        ListenableFuture future = kafka.send(KafkaProdicerConfig.TOPIC_NAME, String.valueOf(ThreadLocalRandom.current().nextLong()), jsonMessage);
        future.addCallback(stringCallbackListener);
    }
}
