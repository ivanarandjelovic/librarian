package org.aivan.librarian.controller;

import org.aivan.librarian.dao.entity.Book;
import org.aivan.librarian.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

	public static final String URL_OPEN_NEW_BOOK = "/openNewBook";
	public static final String URL_CREATE_NEW_BOOK = "/createNewBook";
	public static final String URL_EDIT_BOOK = "/editBook";

	public static final String VIEW_NEW_BOOK = "new_book";
	public static final String VIEW_NEW_BOOK_CREATED = "new_book_created";
	public static final String VIEW_EDIT_BOOK = "edit_book";
	public static final String VIEW_EDIT_BOOK_DONE = "edit_book_done";

	public static final String ATTR_BOOK = "book";

	public static final String PARAM_TITLE = "title";
	public static final String PARAM_ID = "id";

	BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@RequestMapping(value = URL_OPEN_NEW_BOOK, method = RequestMethod.GET)
	public String openNewBook() {
		return VIEW_NEW_BOOK;
	}
	
	@RequestMapping(value = URL_CREATE_NEW_BOOK, method = RequestMethod.POST)
	public String createNewBook(@RequestParam(PARAM_TITLE) String title, Model model) {
		Book book = bookService.createBook(title);
		model.addAttribute(ATTR_BOOK, book);
		return VIEW_NEW_BOOK_CREATED;
	}
	
	@RequestMapping(value = URL_EDIT_BOOK)
	public String editBook(@RequestParam(PARAM_ID) Long id, Model model) {
		Book book = bookService.getBook(id);
		model.addAttribute(ATTR_BOOK, book);
		return VIEW_EDIT_BOOK;
	}
	
	@RequestMapping(value = URL_EDIT_BOOK, params="saveButton")
	public String saveBook(@RequestParam(PARAM_ID) Long id, @RequestParam(PARAM_TITLE) String title, Model model) {
		Book book = bookService.getBook(id);
		book.setTitle(title);
		bookService.updateBook(book);
		model.addAttribute(ATTR_BOOK, book);
		return VIEW_EDIT_BOOK_DONE;
	}
	
	
}
