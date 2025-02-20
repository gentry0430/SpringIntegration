package com.example.Integration.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.MessageChannel;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();  // 메시지를 전달할 채널
    }

    @Bean
    public MessageChannel outputChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow messageFilterFlow() {
        return IntegrationFlows.from(inputChannel())
                .filter(String.class, msg -> msg.contains("Spring"))
                .channel(outputChannel())
                .handle(msg -> System.out.println("✅ Allowed Message: " + msg))
                .get();
    }
}