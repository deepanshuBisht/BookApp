package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		List<Book>bookByAuthor = bookList.stream().filter(book->book.getAuthor().equals(author))
		.collect(Collectors.toList());
		if(bookList.isEmpty()) {
			throw new BookNotFoundException("No Book Found");
		}
		return bookByAuthor;
	}

	@Override
	public Book getById(int id) throws BookNotFoundException {
		return bookList.stream().filter(book->book.getBookId()==id).findFirst()
		.orElseThrow(()->new BookNotFoundException("No Book Found with this Number"));
		
	}

	@Override
	public List<Book> getAllBooks() {
		return bookList;
	}

}
