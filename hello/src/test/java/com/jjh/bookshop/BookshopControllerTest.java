package com.jjh.bookshop;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookshopControllerTest extends BookshopController {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BookshopControllerTest.setUpBeforeClass()");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("BookshopControllerTest.setUpAfterClass()");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BookshopControllerTest.setUp()");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("BookshopControllerTest.tearDown()");
	}

	@Test
	void testNumberOfInitialBooks() {
		System.out.println("BookshopControllerTest.test()");
		List<Book> list = this.getAllBooks();
		assertEquals(2, list.size(), "Initial number of books should be 2");
	}

}
