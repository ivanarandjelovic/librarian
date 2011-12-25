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
public class NewBookController {

	BookService bookService;

	@Autowired
	public NewBookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@RequestMapping(value = "/createNewBook", method = RequestMethod.POST)
	public String createNewBook(@RequestParam("title") String title, Model model) {
		Book book = bookService.createBook(title);
		model.addAttribute("book", book);
		return "new_book_created";
	}
	
	@RequestMapping(value = "/openNewBook", method = RequestMethod.GET)
	public String openNewBook() {
		return "new_book";
	}
	
	
}
