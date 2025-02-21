package com.example.Integration;

import com.example.Integration.test.MyGateway;
import com.example.Integration.test.MessageHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class IntegrationApplication implements CommandLineRunner {

	//Point-to-Point
	private final MyGateway gateway;
	//Broadcast
	private final MessageHandler messageProducer;

	public IntegrationApplication(MyGateway gateway, MessageHandler messageProducer) {
		this.gateway = gateway;
		this.messageProducer = messageProducer;
	}

	public static void main(String[] args) {
		SpringApplication.run(IntegrationApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Sending message..");
		//Point to Point gateway 호출
		gateway.sendMessage("Hello, Spring Integration!", "user123");
		//Broadcast
		messageProducer.sendMessage("Hello, Spring Integration Broadcast!");
	}


}