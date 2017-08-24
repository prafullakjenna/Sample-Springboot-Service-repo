package com.globomart.product.catalog.exception;

public class InvalidProductTypeException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidProductTypeException (final String message) {
		super(message);
	}

}
