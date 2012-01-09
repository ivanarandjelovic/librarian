package org.aivan.librarian.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
	public void testHomePage() {
		beginAt("/");
		clickLink("openNewBook");
		assertTitleEquals("Librarian - Create New Book");
		String title="new book" + System.currentTimeMillis();
		setTextField("title", title);
		clickButton("createNewBookButton");
		assertTitleEquals("Librarian - New Book Created");
		clickLink("homeLink");
		assertTitleEquals("Librarian Home Page");
		
	}

	@Test
	public void testEditBook() {
		beginAt("/");
		clickLink("editBookLink_1");
		assertTitleEquals("Librarian - Edit Book");
		String newTitle="new book" + System.currentTimeMillis();
		setTextField("title", newTitle);
		clickButton("saveButton");
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
		setTextField("title", newTitle);
		clickButton("saveButton");
		assertTitleEquals("Librarian - Edit Book");
		assertTextPresent(messages.getProperty(BookValidator.KEY_BOOK_TITLE_EMPTY));
		
	}

}