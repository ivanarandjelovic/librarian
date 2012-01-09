package org.aivan.librarian.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import static org.springframework.test.web.ModelAndViewAssert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/root-context.xml", "/spring/appServlet/servlet-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=true)
public class BookControllerCTest extends AbstractTransactionalJUnit4SpringContextTests {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private HandlerAdapter handlerAdapter;
	@Autowired
	private BookController newBookController;

	@Before
	public void setUp() throws Exception {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		handlerAdapter = new AnnotationMethodHandlerAdapter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewBookControllerPresent() {
		assertNotNull("NewBookController not present", newBookController);
	}

	@Test
	public void testOpenNewBook() throws Exception {

		request.setRequestURI(BookController.URL_OPEN_NEW_BOOK);
		request.setMethod("GET");
		final ModelAndView mav = handlerAdapter.handle(request, response, newBookController);
		assertViewName(mav, BookController.VIEW_NEW_BOOK);
	}

	@Test
	public void testCreateNewBook() throws Exception {
	
		request.setRequestURI(BookController.URL_CREATE_NEW_BOOK);
		request.setMethod("POST");
		String title = "TEST title "+ System.currentTimeMillis();
		request.setParameter(BookController.PARAM_TITLE, title);
		final ModelAndView mav = handlerAdapter.handle(request, response, newBookController);
		assertViewName(mav, BookController.VIEW_NEW_BOOK_CREATED);
		assertModelAttributeAvailable(mav, BookController.ATTR_BOOK);		
	}

	@Test
	public void testEditBook() throws Exception {

		request.setRequestURI(BookController.URL_EDIT_BOOK);
		request.setMethod("GET");
		request.addParameter("id", "1");
		final ModelAndView mav = handlerAdapter.handle(request, response, newBookController);
		assertViewName(mav, BookController.VIEW_EDIT_BOOK);
		assertModelAttributeAvailable(mav, BookController.ATTR_BOOK);		
	}

	@Test
	public void testEditBookDone() throws Exception {
		
		String newTestBookTitle = "test book title "+System.currentTimeMillis();
		
		request.setRequestURI(BookController.URL_EDIT_BOOK);
		request.setMethod("POST");
		request.addParameter("id", "1");
		request.addParameter("title", newTestBookTitle);
		request.addParameter("saveButton", "Save");
		final ModelAndView mav = handlerAdapter.handle(request, response, newBookController);
		assertViewName(mav, BookController.VIEW_EDIT_BOOK_DONE);
		assertModelAttributeAvailable(mav, BookController.ATTR_BOOK);	
	}

	@Test
	public void testEditBookEmptyTitleDone() throws Exception {
		
		String newTestBookTitle = "";
		
		request.setRequestURI(BookController.URL_EDIT_BOOK);
		request.setMethod("POST");
		request.addParameter("id", "1");
		request.addParameter("title", newTestBookTitle);
		request.addParameter("saveButton", "Save");
		final ModelAndView mav = handlerAdapter.handle(request, response, newBookController);
		assertViewName(mav, BookController.VIEW_EDIT_BOOK);
		assertModelAttributeAvailable(mav, BookController.ATTR_BOOK);
		final BindingResult errors = assertAndReturnModelAttributeOfType(mav,"org.springframework.validation.BindingResult.book",BindingResult.class);
		assertTrue("There should be binding error for empty title",errors.hasErrors());
	}

}
