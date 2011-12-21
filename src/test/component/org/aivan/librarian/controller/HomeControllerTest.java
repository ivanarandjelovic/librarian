package org.aivan.librarian.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/root-context.xml", "/spring/appServlet/servlet-context.xml" } )
public class HomeControllerTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private HomeController homeController;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testControllerPresent() {
		assertNotNull("Controller not present", homeController);
	}

	// See: http://blog.daum.net/kte472ca/8
}
