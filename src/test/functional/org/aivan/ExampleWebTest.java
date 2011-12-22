package org.aivan;

import java.util.Date;

import net.sourceforge.jwebunit.exception.TestingEngineResponseException;

import org.junit.*;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import static org.junit.Assert.*;

public class ExampleWebTest {

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

	@Test
	public void testInvalidPage() {
		try {
			beginAt("/___zzz___");
			fail("this was invalid URL, should have failed!");
		} catch (TestingEngineResponseException e) {
			// TODO: handle exception
			assertTrue("Status code should be 404",e.getMessage().contains("404"));
			assert(true);
		}
	}
}