package com.globomart.product.catalog.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.globomart.product.catalog.model")
@EnableJpaRepositories("com.globomart.product.catalog.repository")
@ComponentScan(basePackages = "com.globomart.product.catalog")

public class ProductCatalogApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ProductCatalogApplication.class, args);
		
	}
}
