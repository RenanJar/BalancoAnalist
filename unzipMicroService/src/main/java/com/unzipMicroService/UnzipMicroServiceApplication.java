package com.unzipMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;

@SpringBootApplication
@EnableScheduling
public class UnzipMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnzipMicroServiceApplication.class, args);


	}

}
