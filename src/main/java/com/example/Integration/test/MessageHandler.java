package com.example.Integration.test;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {

    @ServiceActivator(inputChannel = "outputChannel")
    public void handleMessage(String message) {
        System.out.println("Final Processed Message: " + message);
    }
}