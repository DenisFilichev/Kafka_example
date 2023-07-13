package com.example.api;

import com.example.dto.MessageStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/message")
public class CustomeRest {

    @GetMapping
    public List<String> getMessages(){
        return MessageStore.store.stream().map(e -> e.getNumber() + ": " + e.getMessage()).collect(Collectors.toList());
    }
}
