package com.example.Client_JCDiamante;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class ClientJcDiamanteApplication implements Controller {

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	private String appName;

	@Override
	public String greeting() {
		return "Hello " + eurekaClient.getApplication(appName).getName();
	}

	@Override
	public List<Book> getBooks() {
		return List.of();
	}

	@Override
	public String infoPage() {
		return "{ \"endpoints\": [ \"/hello\", \"/books\" ] }";
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientJcDiamanteApplication.class, args);
	}



}
