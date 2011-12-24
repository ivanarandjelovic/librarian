package org.aivan.librarian.controller;

import static org.junit.Assert.*;

import java.util.List;
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

public class HomeControllerUTest {

	HomeController homeController;

	Locale locale;

	@Before
	public void setUp() throws Exception {

		BookDao bookDaoMock = UnitTestData.createBookDaoMock();

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
		assertTrue("Model attribute books is wrong size",
				((List<Book>) (model.asMap().get("books"))).size() == UnitTestData.testBooks.length);

	}

}
