package com.jjh.bookshop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookshop")
public class BookshopController {
	
	private List<Book> contents = new ArrayList<Book>();
	
	public BookshopController() {
		contents.add(new Book("121", "John Hunt", "Java for Practitioners", 15.55));
		contents.add(new Book("212", "John Hunt", "Introduction to Python 3", 14.95));
	}
	
	@GetMapping("{isbn}")
	public Book getBook(@PathVariable String isbn) {
		System.out.println("BookshopController.getBook(" + isbn + ")");
		Book result = null;
		for (Book b : contents) {
			if (b.getISBN().equalsIgnoreCase(isbn)) {
				result = b;
			}
		}
		return result;
	}
	
	@GetMapping("list")
	public List<Book> getAllBooks() {
		System.out.println("BookshopController.getAllBooks()");
		return this.contents;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void addBook(@RequestBody Book book) {
		System.out.println("BookshopController.addBook(" + book + ")");
		if (!this.contents.contains(book)) {
			this.contents.add(book);
		}
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void updateBook(@RequestBody Book newVersionOfBook) {
		System.out.println("BookshopController.updateBook(" + newVersionOfBook + ")");
		Book originalBook = this.getBook(newVersionOfBook.getISBN());
		if (originalBook == null)
			throw new RuntimeException("Book with isbn: " + newVersionOfBook.getISBN() + " not found");
		originalBook.setAuthor(newVersionOfBook.getAuthor());
		originalBook.setTitle(newVersionOfBook.getTitle());
		originalBook.setPrice(newVersionOfBook.getPrice());
	}
	
	@DeleteMapping("{isbn}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteBook(@PathVariable String isbn) {
		System.out.println("BookshopController.deleteBook(" + isbn + ")");
		Book book = this.getBook(isbn);
		if (book != null)
			this.contents.remove(book);
		else
			throw new RuntimeException("Book with isbn: " + isbn + " not found");
	}
	

}
