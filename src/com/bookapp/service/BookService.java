package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public interface BookService {
	void addBook(Book book);
	List<Book> getBookByAuthor(String author) throws BookNotFoundException;
	Book getById(int id) throws BookNotFoundException;
	List<Book> getAllBooks();
}
