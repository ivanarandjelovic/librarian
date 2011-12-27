package org.aivan.librarian.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;

	
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

}
