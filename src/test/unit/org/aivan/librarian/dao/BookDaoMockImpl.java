package org.aivan.librarian.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aivan.librarian.dao.entity.Book;

public class BookDaoMockImpl implements BookDao {

  // Mock internal code

  public static long counter = 0;

  Map<Long, Book> books = new HashMap<Long, Book>();

  public Map<Long, Book> getBooks() {
    return books;
  }

  public void setBooks(Map<Long, Book> books) {
    this.books = books;
  }

  // Mock methods

  @Override
  public void createBook(Book book) {
    book.setId(new Long(++counter));
    updateBook(book);
  }

  @Override
  public Book getBook(Long bookId) {
    return books.get(bookId);
  }

  @Override
  public List<Book> getAllBooks() {
    return new ArrayList<Book>(books.values());
  }

  @Override
  public void updateBook(Book book) {
    books.put(book.getId(), book);
  }

  @Override
  public void deleteBook(Long id) {
    books.remove(id);
  }

}
