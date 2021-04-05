package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImple implements BookService {
	
	List<Book> bookList = new ArrayList<>();
	
	@Override
	public void addBook(Book book) {
		bookList.add(book);

	}
	
	@Override
	public List<Book> getBookByAuthor(String author) throws BookNotFoundException {
		List<Book> booksByAuthor = new ArrayList<>();
		for(Book book : bookList) {
			if(book.getAuthor().equals(author))
				booksByAuthor.add(book);
		}if(booksByAuthor.isEmpty())
			throw new BookNotFoundException("No Book Found with this Author");
		return booksByAuthor;
	}

	@Override
	public Book getById(int id) throws BookNotFoundException {
		for(Book book : bookList) {
			if(book.getBookId()==id);
			return book;
		}throw new BookNotFoundException("No Book Found with this Number");
	}

	@Override
	public List<Book> getAllBooks() {
		return bookList;
	}

}
