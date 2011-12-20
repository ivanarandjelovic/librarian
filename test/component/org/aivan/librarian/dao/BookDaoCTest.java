package org.aivan.librarian.dao;

import static org.junit.Assert.*;

import org.aivan.librarian.dao.entity.Book;
import org.hibernate.ObjectNotFoundException;
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
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=true)
@Transactional
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
		try {
			Book book = bookDao.getBook(new Long(NON_EXISTING_BOOK_ID));
			book.getId();
		} catch (ObjectNotFoundException onf) {
			// This is what we expect
			return;
		}
		fail("Object should  have not been found!");
	}

	@Test
	@Transactional
	public void testCreateBook() {
		Book newBook = new Book();
		assert (newBook.getId() == 0);
		newBook.setTitle("book title 1");
		bookDao.createBook(newBook);
		assert (newBook.getId() != 0);
	}

}
