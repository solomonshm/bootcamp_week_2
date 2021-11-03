package com.jjh.graphql.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bookshop.books.BookDAO;

@Component
public class Bookshop {
	BookDAO bookshop = new BookDAO();

	public Bookshop() {
		bookshop.saveBook(new Book("121", "Java", "Technical", "John Smith"));
		bookshop.saveBook(new Book("345", "Death in the Spring", "Detective", "Denise Jones"));
		bookshop.saveBook(new Book("987", "Henry VI", "Historical", "Phoebe Davies"));
	}

	public List<Book> getBooks(int count) {
		System.out.println("BookDao.getBooks");
		return bookshop.getAllBooks();
	}

	public List<Book> getAllBooks() {

		return bookshop.getAllBooks();
	}

}
