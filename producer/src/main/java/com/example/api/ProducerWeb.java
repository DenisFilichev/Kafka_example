package com.example.api;

import com.example.producer.SenderService;
import com.example.dto.RestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/message")
public class ProducerWeb {
    private final SenderService producer;

    @Autowired
    public ProducerWeb(SenderService producer) {
        this.producer = producer;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createMessage(@Valid @RequestBody RestMessage message){
        producer.send(message.getMessage());
    }
}
