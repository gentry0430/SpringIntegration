package com.example.Integration.test;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "inputChannel")
public interface MyGateway {
    void sendMessage(String message, @Header("userId") String userId);
}