package com.jjh.bookshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookshopServicesApp {

	public static void main(String[] args) {
		System.out.println("Starting Bookshop setup");
		SpringApplication.run(BookshopServicesApp.class, args);
		System.out.println("To Test use - http://localhost:8080/bookshop/list");
		System.out.println("Setup finished");
	}

}
