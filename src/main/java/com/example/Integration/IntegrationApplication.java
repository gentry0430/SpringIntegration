package com.example.Integration;

import com.example.Integration.test.MyGateway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IntegrationApplication implements CommandLineRunner {

	private final MyGateway gateway;

	public IntegrationApplication(MyGateway gateway) {
		this.gateway = gateway;
	}

	public static void main(String[] args) {
		SpringApplication.run(IntegrationApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Sending message..");
		gateway.sendMessage("Hello, Spring Integration!", "user123");
	}
}