package org.aivan.librarian.dao.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BookValidator implements Validator {

	public static final String KEY_BOOK_TITLE_EMPTY = "book.title.empty";
	public static final String FIELD_TITLE = "title";

	@Override
	public boolean supports(Class<?> validatedClass) {
		return Book.class.isAssignableFrom(validatedClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_TITLE, KEY_BOOK_TITLE_EMPTY);
	}

}
