package org.aivan.librarian.ui;

import static org.junit.Assert.*;

import net.sourceforge.jwebunit.exception.TestingEngineResponseException;

import org.junit.*;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class InvalidPageWebTest {

	@Before
	public void setUp() throws Exception {
		setBaseUrl("http://localhost:8080/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInvalidPage() {
		try {
			beginAt("/___zzz___");
			fail("this was invalid URL, should have failed!");
		} catch (TestingEngineResponseException e) {
			// TODO: handle exception
			assertTrue("Status code should be 404", e.getMessage().contains("404"));
			assert (true);
		}
	}

}
