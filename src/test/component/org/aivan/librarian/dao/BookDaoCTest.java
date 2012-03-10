package org.aivan.librarian.dao;

import static org.junit.Assert.*;

import org.aivan.librarian.dao.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/root-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BookDaoCTest extends AbstractTransactionalJUnit4SpringContextTests {

	private static final int NON_EXISTING_BOOK_ID = -1;

	@Autowired
	private BookDao bookDao;

	@Test
	public void testDaoPresent() {
		assertNotNull("bookDAO is null", bookDao);
	}

	@Test
	@Transactional
	public void testNonexistingBook() {
		Book book = bookDao.getBook(new Long(NON_EXISTING_BOOK_ID));
		assertNull("Book expected to be null", book);
	}

	@Test
	@Transactional
	public void testCreateBook() {
		Book newBook = new Book();
		assert (newBook.getId() == 0);
		newBook.setTitle("book title 1");
		bookDao.createBook(newBook);
		assert (newBook.getId() != 0);
		Book book = bookDao.getBook(newBook.getId());
		assert (book.getId() == newBook.getId());
		assertEquals("Book title is not identical", newBook.getTitle(), book.getTitle());
	}

	@Test
	@Transactional
	public void testUpdateBook() {

		String testTitle = "testTitle" + System.currentTimeMillis();

		Book newBook = new Book();
		newBook.setTitle("book title 1");
		bookDao.createBook(newBook);

		Book book = bookDao.getBook(newBook.getId());
		book.setTitle(testTitle);
		bookDao.updateBook(book);

		assertEquals("Update book Title is not correct", testTitle, book.getTitle());
	}

  @Test
  @Transactional
  public void testDeleteBook() {

    Book newBook = new Book();
    newBook.setTitle("book title deletion test 1");
    bookDao.createBook(newBook);

    bookDao.deleteBook(newBook.getId());

    Book deletedBook = bookDao.getBook(newBook.getId());
    assertNull("Book should have been deleted", deletedBook);
    
  }

}
