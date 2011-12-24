package org.aivan.librarian.controller;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Locale;

import org.aivan.librarian.dao.BookDao;
import org.aivan.librarian.dao.BookDaoMockImpl;
import org.aivan.librarian.dao.entity.Book;
import org.aivan.librarian.dao.entity.BookMock;
import org.aivan.librarian.service.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

public class HomeControllerUTest {

	HomeController homeController;

	Locale locale;

	Book[] testBooks = new Book[] { new BookMock(-1, "Book 1"), new BookMock(-2, "Book 2"), new BookMock(-3, "Book 3"),
			new BookMock(-4, "Book 4"), new BookMock(-5, "Book 5") };

	@Before
	public void setUp() throws Exception {

		BookDao bookDaoMock = new BookDaoMockImpl();

		for (Book book : testBooks) {
			bookDaoMock.createBook(book);
		}

		BookService bookService = new BookService(bookDaoMock);

		homeController = new HomeController(bookService);

		locale = new Locale("en");
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testHomePage() {
		Model model = new ExtendedModelMap();
		String view = homeController.home(locale, model);
		assertEquals("View is not home", "home", view);
		assertTrue("Model does not contains books", model.containsAttribute("books"));
		assertTrue("Model attribute books is wrong size", ((List<Book>)(model.asMap().get("books"))).size() ==  testBooks.length);
		
	}

}
