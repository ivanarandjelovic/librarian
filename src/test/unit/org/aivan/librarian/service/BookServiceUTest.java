package org.aivan.librarian.service;

import static org.junit.Assert.*;

import java.util.List;

import org.aivan.librarian.dao.BookDaoMockImpl;
import org.aivan.librarian.dao.entity.Book;
import org.aivan.librarian.dao.entity.BookMock;
import org.junit.Before;
import org.junit.Test;

public class BookServiceUTest {

	BookDaoMockImpl bookDaoMock;
	BookService bookService;

	Book[] testBooks = new Book[] { new BookMock(-1, "Book 1"),
			new BookMock(-2, "Book 2"), new BookMock(-3, "Book 3"),
			new BookMock(-4, "Book 4"), new BookMock(-5, "Book 5") };

	@Before
	public void setUp() {

		bookDaoMock = new BookDaoMockImpl();

		for (Book book : testBooks) {
			bookDaoMock.createBook(book);
		}

		bookService = new BookService(bookDaoMock);
	}

	@Test
	public void testGetAllBooks() {
		List<Book> books  = bookService.getAllBooks();
		assertNotNull("result should be list of books", books);
		assertTrue("Number of books is not as expected",  books.size() == testBooks.length);
		for(Book book : books) {
			assertNotNull("Book must not be NULL", book);
		}
	}

	@Test
	public void testGetBook() {
		
		for(Book testBook : testBooks) {
			Book book  = bookService.getBook(testBook.getId());
			assertNotNull(book);
			assertTrue(book.getId().equals(testBook.getId()));
			assertTrue(book.getTitle().equals(testBook.getTitle()));
		}

	}

}
