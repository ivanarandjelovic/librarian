package org.aivan.librarian.ui;

import org.junit.*;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class BookWebTest {

	@Before
	public void prepare() {
		setBaseUrl("http://localhost:8080/");
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

}