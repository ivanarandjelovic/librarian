package org.aivan.librarian.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.aivan.librarian.dao.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

//TODO: It is not possible to have 100% unite test coverage with classes like these? Or is it?

@Repository
public class BookDaoHibernateImpl implements BookDao {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	public void createBook(Book book) {
		hibernateTemplate.save(book);
	}
    
	public Book getBook(Long Id) {
		Book book = (Book) hibernateTemplate.load(Book.class, Id);
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		 return hibernateTemplate.loadAll(Book.class);
	}

}
