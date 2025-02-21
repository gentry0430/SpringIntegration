package com.example.Integration.test;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

@Component
public class MessageTransformer {
    @Transformer(inputChannel = "inputChannel", outputChannel = "outputChannel")
    public String transform(String message) {
        System.out.println("Transforming Message: " + message);
        return "Transformed: " + message.toUpperCase();
    }
}