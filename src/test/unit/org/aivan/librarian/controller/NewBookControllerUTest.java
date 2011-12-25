package org.aivan.librarian.controller;

import static org.junit.Assert.*;

import java.util.Locale;

import org.aivan.librarian.dao.BookDao;
import org.aivan.librarian.dao.entity.Book;
import org.aivan.librarian.service.BookService;
import org.aivan.librarian.testdata.UnitTestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class NewBookControllerUTest {

	NewBookController newBookController;

	Locale locale;

	@Before
	public void setUp() throws Exception {
		BookDao bookDaoMock = UnitTestData.createBookDaoMock();

		BookService bookService = new BookService(bookDaoMock);

		newBookController = new NewBookController(bookService);

		locale = new Locale("en");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateNewBook() {
		Model model = new ExtendedModelMap();
		String bookTitle = "test book title "+System.currentTimeMillis();
		String view = newBookController.createNewBook(bookTitle, model);
		assertEquals("new book creation view is wrong", "new_book_created", view);
		assertTrue("model does not contain new book object", model.containsAttribute("book"));
		assertTrue(model.asMap().get("book") instanceof Book);
		Book book = (Book) model.asMap().get("book");
		assertEquals("book title is wrong", bookTitle, book.getTitle());
		assertTrue("book id is zero or null", book.getId() != 0 && book.getId() != null);
	}

	@Test
	public void testOpenNewBook() {
		String view = newBookController.openNewBook();
		assertEquals("new book opening page/view  is wrong", "new_book", view);
	}

}
