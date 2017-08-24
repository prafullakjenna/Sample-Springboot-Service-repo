package com.globomart.product.catalog.exception;


public class InvalidProductIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidProductIdException (final String message) {
		super(message);
	}

}
