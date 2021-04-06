package com.bookapp.client;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImple;

class UserMain {

	public static void main(String[] args) {

		BookService service = new BookServiceImple();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {
			System.out.println("Enter Author Name");
			String author = sc.next();
			System.out.println("Enter Title Name");
			String title = sc.next();
			System.out.println("Enter Category Name");
			String category = sc.next();
			System.out.println("Enter Book Number");
			int bookid = sc.nextInt();
			Book book = new Book(bookid, title, author, category);
			service.addBook(book);
		}

		System.out.println("All Books");
		for (Book book : service.getAllBooks()) {
			System.out.println(book);
		}
		System.out.println();

		System.out.println("By Author");
		List<Book> bookByAuthor = null;
		String author = sc.next();
		try {
			bookByAuthor = service.getBookByAuthor(author);
			Collections.sort(bookByAuthor, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
			for (Book book : bookByAuthor) {
				System.out.println(book);
			}
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("By ID");
		Book book;
		try {
			book = service.getById(10);
			System.out.println(book);
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if (sc != null)
				sc.close();
		}

	}

}
