package org.aivan.librarian.dao;

import java.util.List;

import org.aivan.librarian.dao.entity.Book;

public interface BookDao {

	void createBook(Book book);
	
	Book getBook(Long bookId);

	List<Book> getAllBooks();
	
}