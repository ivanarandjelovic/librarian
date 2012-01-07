package org.aivan.librarian.service;

import static org.junit.Assert.*;

import java.util.List;

import org.aivan.librarian.dao.entity.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/root-context.xml" })
@TransactionConfiguration(defaultRollback=true)
public class BookServiceCTest {

	private static final Long KNOWN_BOOK_ID = new Long(1);
	private static final String KNOWN_BOOK_TITLE = "Test Book";

	@Autowired
	BookService bookService;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Transactional
	public void testGetAllBooks() {
		List<Book> books = bookService.getAllBooks();
		assertNotNull("List of book should never be null",books);
	}

	//@Test
	@Transactional
	public void testGetOneBook() {
		Book book = bookService.getBook(KNOWN_BOOK_ID);
		assertNotNull("Known book was not found",book);
		assertEquals("Known book ID is not correct", KNOWN_BOOK_ID, book.getId());
		assertEquals("Known book Title is not correct", KNOWN_BOOK_TITLE, book.getTitle());
	}

	//@Test
	@Transactional
	public void testUpdateBook() {
		
		String testTitle = "testTitle"+System.currentTimeMillis();

		Book book = bookService.getBook(KNOWN_BOOK_ID);
		book.setTitle(testTitle);
		bookService.updateBook(book);

		book = bookService.getBook(KNOWN_BOOK_ID);
		assertEquals("Update book Title is not correct", testTitle, book.getTitle());
	}

}
