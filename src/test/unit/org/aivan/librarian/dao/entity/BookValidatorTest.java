package org.aivan.librarian.dao.entity;

import static org.junit.Assert.*;

import org.aivan.librarian.controller.BookValidator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindException;

public class BookValidatorTest {

	BookValidator bookValidator;
	
	@Before
	public void setUp() throws Exception {
		bookValidator = new BookValidator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSupportedClass() {
		assertTrue("Book class should be supported",bookValidator.supports(Book.class));
	}

	@Test
	public void testValidationEmptyTitle() {
		Book book = new Book();
		book.setTitle("");
		
		BindException binding = new BindException(book,"book");
		
		bookValidator.validate(book, binding);
		
		assertTrue("Binding should contain error", binding.hasErrors());
	}

	@Test
	public void testValidationRegaularCase() {

		Book book = new Book();
		book.setTitle("non-empty");
		
		BindException binding = new BindException(book,"book");
		
		bookValidator.validate(book, binding);
		
		assertFalse("Binding should not contain error(s)", binding.hasErrors());
	}

}
