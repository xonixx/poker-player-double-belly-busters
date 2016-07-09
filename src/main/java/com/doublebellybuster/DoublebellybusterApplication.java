package com.doublebellybuster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class})
public class DoublebellybusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoublebellybusterApplication.class, args);
	}
}
