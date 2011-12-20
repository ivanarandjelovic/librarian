package org.aivan.librarian.dao.entity;

public class BookMock extends Book {

	public BookMock(int id, String title) {
		super();
		setId(new Long(id));
		setTitle(title);
	}

}
