package com.jjh.microservices.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@Configuration
@ComponentScan
public class ShopService {

	public static void main(String[] args) {
		System.out.println("Starting the BookShop Service");
		// Will configure using shop-service.yml
		System.setProperty("spring.config.name", "shop-service");
		SpringApplication.run(ShopService.class, args);
		System.out.println("Bookshop Service started - see http://localhost:3333");
	}
	
	@LoadBalanced    // Make sure to create the load-balanced template
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
