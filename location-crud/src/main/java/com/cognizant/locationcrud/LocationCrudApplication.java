package com.cognizant.locationcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LocationCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationCrudApplication.class, args);
	}

}
