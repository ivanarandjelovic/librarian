package org.aivan.librarian.dao;

import org.hibernate.SessionFactory;
import org.aivan.librarian.dao.entity.Book;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BookDaoImpl implements BookDao {

	private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
	public void createBook(Book book) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(book);
	}
    
	public Book getBook(Long Id) {
		// TODO Auto-generated method stub
		Book book = (Book) hibernateTemplate.load(Book.class, Id);
		return book;
	}

}
