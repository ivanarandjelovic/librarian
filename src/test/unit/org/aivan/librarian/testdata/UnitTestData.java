package org.aivan.librarian.testdata;

import org.aivan.librarian.dao.BookDaoMockImpl;
import org.aivan.librarian.dao.entity.Book;
import org.aivan.librarian.dao.entity.BookMock;

public class UnitTestData {

	public static Book[] testBooks = new Book[] { new BookMock(-1, "Book 1"), new BookMock(-2, "Book 2"),
	new BookMock(-3, "Book 3"), new BookMock(-4, "Book 4"), new BookMock(-5, "Book 5") };

	public static BookDaoMockImpl createBookDaoMock() {
	  BookDaoMockImpl bookDaoMock = new BookDaoMockImpl();

		for (Book book : UnitTestData.testBooks) {
			bookDaoMock.createBook(book);
		}
		return bookDaoMock;
	}
	
}
