package com.cognizant.productcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCrudApplication.class, args);
	}

}
