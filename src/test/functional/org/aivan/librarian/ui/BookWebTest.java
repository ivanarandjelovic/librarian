package org.aivan.librarian.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.aivan.librarian.controller.BookController;
import org.aivan.librarian.dao.entity.BookValidator;
import org.junit.*;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class BookWebTest {

	Properties messages;
	
	@Before
	public void prepare() throws FileNotFoundException, IOException {
		setBaseUrl("http://localhost:8080/");
		messages = new Properties();
		messages.load(this.getClass().getClassLoader().getResourceAsStream("messages.properties"));
	}

	@Test
	public void testCreateBook() {
		beginAt("/");
		clickLink("createNewBook");
		assertTitleEquals("Librarian - Create New Book");
		String title="new book" + System.currentTimeMillis();
		setTextField(BookController.PARAM_TITLE, title);
		clickButton(BookController.PARAM_CREATE_BUTTON);
		assertTitleEquals("Librarian - New Book Created");
		clickLink("homeLink");
		assertTitleEquals("Librarian Home Page");
		
	}

	@Test
	public void testCreateBookEmptyTitle() {
		beginAt("/");
		clickLink("createNewBook");
		assertTitleEquals("Librarian - Create New Book");
		String title="";
		setTextField(BookController.PARAM_TITLE, title);
		clickButton(BookController.PARAM_CREATE_BUTTON);
		assertTitleEquals("Librarian - Create New Book");
		assertTextPresent(messages.getProperty(BookValidator.KEY_BOOK_TITLE_EMPTY));
		
	}

	@Test
	public void testEditBook() {
		beginAt("/");
		clickLink("editBookLink_1");
		assertTitleEquals("Librarian - Edit Book");
		String newTitle="new book" + System.currentTimeMillis();
		setTextField(BookController.PARAM_TITLE, newTitle);
		clickButton(BookController.PARAM_SAVE_BUTTON);
		assertTitleEquals("Librarian - Book edited");
		clickLink("homeLink");
		assertTitleEquals("Librarian Home Page");
		
	}

	@Test
	public void testEditBookEmptyTitle() {
		beginAt("/");
		clickLink("editBookLink_1");
		assertTitleEquals("Librarian - Edit Book");
		String newTitle="";
		setTextField(BookController.PARAM_TITLE, newTitle);
		clickButton(BookController.PARAM_SAVE_BUTTON);
		assertTitleEquals("Librarian - Edit Book");
		assertTextPresent(messages.getProperty(BookValidator.KEY_BOOK_TITLE_EMPTY));
		
	}

}