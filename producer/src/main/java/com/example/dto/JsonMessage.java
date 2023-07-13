package com.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JsonMessage {

    private long number;

    private String message;

}
