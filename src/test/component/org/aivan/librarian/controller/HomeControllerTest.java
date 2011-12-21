package org.aivan.librarian.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
public class HomeControllerTest extends AbstractJUnit4SpringContextTests {

	private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private HandlerAdapter handlerAdapter;
	@Autowired
	private HomeController homeController;

	
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
	public void testControllerPresent() {
		assertNotNull("Controller not present", homeController);
	}

	@Test
	public void testHome() throws Exception {

		request.setRequestURI("/");
		request.setMethod("GET");
	       final ModelAndView mav = handlerAdapter.handle(request, response, 
	           homeController);
	       assertViewName(mav, "home");
	       assertModelAttributeAvailable(mav, "books");
	       assertModelAttributeAvailable(mav, "serverTime");

	}

}
