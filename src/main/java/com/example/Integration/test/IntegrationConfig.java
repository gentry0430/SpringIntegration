package com.example.Integration.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {

    //Point-to-Point Start
    @Bean
    public MessageChannel fileInputChannel() {
        return new DirectChannel();  // 메시지를 전달할 채널
    }

    @Bean
    public MessageChannel outputChannel() {
        return new DirectChannel();
    }

    //Point-to-Point End

    //Broadcast Start
    // 🔹 PublishSubscribeChannel을 사용하여 브로드캐스트 채널 생성
    @Bean
    public MessageChannel pubSubChannel() {
        return new PublishSubscribeChannel();
    }

    // 🔹 Consumer 1 (로그 출력)
    @Bean
    public IntegrationFlow consumer1() {
        return IntegrationFlow
                .from(pubSubChannel())  // Broadcast 메시지를 받음
                .log(LoggingHandler.Level.INFO, "Consumer1 received message: ") // 로그 출력
                .handle(message -> System.out.println("Consumer 1 processed: " + message.getPayload()))
                .get();
    }

    // 🔹 Consumer 2 (추가 메시지 처리)
    @Bean
    public IntegrationFlow consumer2() {
        return IntegrationFlow
                .from(pubSubChannel())  // 동일한 메시지를 또 받음
                .log(LoggingHandler.Level.INFO, "Consumer2 received message: ") // 로그 출력
                .handle(message -> System.out.println("Consumer 2 processed: " + message.getPayload()))
                .get();
    }
    //Broadcast End
}