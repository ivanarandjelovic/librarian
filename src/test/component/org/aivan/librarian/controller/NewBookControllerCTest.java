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
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import static org.springframework.test.web.ModelAndViewAssert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/root-context.xml", "/spring/appServlet/servlet-context.xml" })
public class NewBookControllerCTest extends AbstractJUnit4SpringContextTests {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private HandlerAdapter handlerAdapter;
	@Autowired
	private NewBookController newBookController;

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

		request.setRequestURI(NewBookController.URL_OPEN_NEW_BOOK);
		request.setMethod("GET");
		final ModelAndView mav = handlerAdapter.handle(request, response, newBookController);
		assertViewName(mav, NewBookController.VIEW_NEW_BOOK);
	}

	@Test
	public void testCreateNewBook() throws Exception {
	
		request.setRequestURI(NewBookController.URL_CREATE_NEW_BOOK);
		request.setMethod("POST");
		String title = "TEST title "+ System.currentTimeMillis();
		request.setParameter(NewBookController.PARAM_TITLE, title);
		final ModelAndView mav = handlerAdapter.handle(request, response, newBookController);
		assertViewName(mav, NewBookController.VIEW_NEW_BOOK_CREATED);
		assertModelAttributeAvailable(mav, NewBookController.ATTR_BOOK);		
	}

}
