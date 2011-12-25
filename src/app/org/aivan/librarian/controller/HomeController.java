package org.aivan.librarian.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


import org.aivan.librarian.service.BookService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);;
	
	public static final String URL_ROOT = "/";
	public static final String URL_HOME = "/home";

	public static final String VIEW_HOME = "home";
	
	public static final String ATTR_SERVER_TIME = "serverTime";
	public static final String ATTR_BOOKS = "books";
	
	BookService bookService;
	
	@Autowired
	public HomeController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {URL_ROOT, URL_HOME}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute(ATTR_SERVER_TIME, formattedDate );
		
		model.addAttribute(ATTR_BOOKS, bookService.getAllBooks());
		
		return VIEW_HOME;
	}

}
