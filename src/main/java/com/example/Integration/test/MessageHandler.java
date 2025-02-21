package com.example.Integration.test;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {

    //Point-to-Point
    @ServiceActivator(inputChannel = "outputChannel")
    public void handleMessage(String message) {
        System.out.println("Final Processed Message: " + message);
    }

    //Broadcast
    private final MessageChannel pubSubChannel;

    public MessageHandler(MessageChannel pubSubChannel) {
        this.pubSubChannel = pubSubChannel;
    }

    public void sendMessage(String message) {
        pubSubChannel.send(MessageBuilder.withPayload(message).build());
        System.out.println("Producer sent: " + message);
    }
}