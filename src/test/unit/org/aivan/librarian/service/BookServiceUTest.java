package org.aivan.librarian.service;

import static org.junit.Assert.*;

import java.util.List;

import org.aivan.librarian.dao.BookDao;
import org.aivan.librarian.dao.entity.Book;
import org.aivan.librarian.testdata.UnitTestData;
import org.junit.Before;
import org.junit.Test;

public class BookServiceUTest {

	BookDao bookDaoMock;
	BookService bookService;

	@Before
	public void setUp() {

		bookDaoMock = UnitTestData.createBookDaoMock();

		bookService = new BookService(bookDaoMock);
	}

	@Test
	public void testGetAllBooks() {
		List<Book> books = bookService.getAllBooks();
		assertNotNull("result should be list of books", books);
		assertTrue("Number of books is not as expected", books.size() == UnitTestData.testBooks.length);
		for (Book book : books) {
			assertNotNull("Book must not be NULL", book);
		}
	}

	@Test
	public void testGetBook() {

		for (Book testBook : UnitTestData.testBooks) {
			Book book = bookService.getBook(testBook.getId());
			assertNotNull(book);
			assertTrue(book.getId().equals(testBook.getId()));
			assertTrue(book.getTitle().equals(testBook.getTitle()));
		}

	}

	@Test
	public void testSaveBook() {
		
		String testTitle = "testTitle"+System.currentTimeMillis();
		
		Long id = UnitTestData.testBooks[0].getId();
		Book book = bookService.getBook(id);
		book.setTitle(testTitle);
		bookService.updateBook(book);
		book = bookService.getBook(id);
		assertEquals("Book title is not correct after update", testTitle, book.getTitle());

	}

}
