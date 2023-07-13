package com.example.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RestMessage {

    @NotEmpty
    private String message;
}
