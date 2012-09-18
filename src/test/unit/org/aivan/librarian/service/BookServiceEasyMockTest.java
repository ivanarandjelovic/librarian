package org.aivan.librarian.service;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;


import org.aivan.librarian.dao.BookDao;
import org.aivan.librarian.dao.entity.Book;
import org.junit.Before;
import org.junit.Test;

public class BookServiceEasyMockTest {

  BookDao bookDaoMock;
  BookService bookService;

  @Before
  public void setUp() {

    bookDaoMock = createMock(BookDao.class);

    bookService = new BookService(bookDaoMock);
  }
  
  /**
   * First exercise with EasyMock, not really useful (same as the rest of the project :) )
   */
  @Test
  public void testGetAllBooks() {
    
    List<Book> testBooks = new ArrayList<Book>();
    expect(bookDaoMock.getAllBooks()).andReturn(testBooks);
    
    replay(bookDaoMock);
    
    List<Book> books = bookService.getAllBooks();
    assertNotNull("result should be list of books", books);
    assertTrue("Number of books is not as expected", books.size() == testBooks.size());
    
    verify(bookDaoMock);
  }
  

}
