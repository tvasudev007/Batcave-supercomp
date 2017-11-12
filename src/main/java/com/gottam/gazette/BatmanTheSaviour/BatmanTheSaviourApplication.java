package com.gottam.gazette.BatmanTheSaviour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatmanTheSaviourApplication {

	private static final Logger log = LoggerFactory.getLogger(BatmanTheSaviourApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BatmanTheSaviourApplication.class, args);
	}
}
