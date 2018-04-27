package com.beini.redismq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages="com.beini")
@ImportResource(locations = { "classpath:druid-spring.xml" })
public class RedismqApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedismqApplication.class, args);
	}
}
