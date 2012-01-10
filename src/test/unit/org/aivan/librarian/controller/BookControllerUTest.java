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
import org.springframework.validation.BindException;

public class BookControllerUTest {

	BookController bookController;

	Locale locale;

	@Before
	public void setUp() throws Exception {
		BookDao bookDaoMock = UnitTestData.createBookDaoMock();

		BookService bookService = new BookService(bookDaoMock);

		bookController = new BookController(bookService);

		locale = new Locale("en");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOpenNewBook() {
		Book book = new Book();
		BindException binding = new BindException(book, "book");

		String view = bookController.openNewBook(book, binding);

		assertEquals("new book opening page/view  is wrong", "new_book", view);
	}

	@Test
	public void testCreateNewBook() {
		Book book = UnitTestData.testBooks[0];
		BindException binding = new BindException(book, "book");

		String view = bookController.createNewBook(book, binding);

		assertFalse("Binding should have no errors", binding.hasErrors());
		assertEquals("new book creation view is wrong", "new_book_created", view);
		assertTrue("book id is zero or null", book.getId() != 0 && book.getId() != null);
	}

	@Test
	public void testCreateNewBookEmptyTitle() {
		Book book = UnitTestData.testBooks[0];
		book.setId(null);
		book.setTitle("");

		BindException binding = new BindException(book, "book");

		String view = bookController.createNewBook(book, binding);

		assertTrue("Binding should have error(s)", binding.hasErrors());
		assertEquals("new book creation view is wrong after error", "new_book", view);
		assertTrue("book id should be null", book.getId() == null);
	}

	@Test
	public void testEditBook() {
		Model model = new ExtendedModelMap();
		String view = bookController.editBook(UnitTestData.testBooks[0].getId(), model);
		assertEquals("edit book opening page/view  is wrong", "edit_book", view);
	}

	@Test
	public void testEditBookDone() {

		String newTestBookTitle = "test book title " + System.currentTimeMillis();
		UnitTestData.testBooks[0].setTitle(newTestBookTitle);
		BindException binding = new BindException(UnitTestData.testBooks[0], "book");
		String view = bookController.saveBook(UnitTestData.testBooks[0], binding);
		assertFalse("Binding should have no errors", binding.hasErrors());
		assertEquals("edit book done view is wrong", "edit_book_done", view);
	}

	@Test
	public void testEditBookEmptyTitleDone() {
		String newTestBookTitle = "";
		UnitTestData.testBooks[0].setTitle(newTestBookTitle);
		BindException binding = new BindException(UnitTestData.testBooks[0], "book");
		String view = bookController.saveBook(UnitTestData.testBooks[0], binding);
		assertTrue("Binding should have error!", binding.hasErrors());
		assertEquals("edit book with error should return view for editing again", "edit_book", view);
	}

}
