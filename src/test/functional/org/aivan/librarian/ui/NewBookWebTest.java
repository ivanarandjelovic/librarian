package org.aivan.librarian.ui;

import org.junit.*;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class NewBookWebTest {

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

}