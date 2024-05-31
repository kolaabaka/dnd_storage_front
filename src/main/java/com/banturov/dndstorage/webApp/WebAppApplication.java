package com.banturov.dndstorage.webApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({ "com.banturov.controllers", "com.banturov.configurations", "com.banturov.security",
		"com.banturov.models", "com.banturov.repository" })
@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.banturov.repository" })
@EntityScan("com.banturov.models")
public class WebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

}
