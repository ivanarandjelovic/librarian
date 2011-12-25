package org.aivan.librarian.ui;

import org.junit.*;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class HomeWebTest {

	@Before
	public void prepare() {
		setBaseUrl("http://localhost:8080/");
	}

	@Test
	public void testHomePage() {
		beginAt("/");
		assertTitleEquals("Librarian Home Page");
		assertTextPresent("Hello world! I am Librarian!");
		assertTextPresent("The time on the server is ");
		assertTextPresent("Books");
		/*
		 * setTextField("username", "test"); setTextField("password",
		 * "test123"); submit(); assertTitleEquals("Welcome, test!");
		 */
	}

}