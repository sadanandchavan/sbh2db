package com.sbh2db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sbh2dbApplication {
	
	private static Logger logger = LogManager.getLogger(Sbh2dbApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(Sbh2dbApplication.class, args);
		logger.info("Application start..................");
	}

}
