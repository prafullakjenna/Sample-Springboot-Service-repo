package com.globomart.product.catalog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.globomart.product.catalog.exception.InvalidProductIdException;
import com.globomart.product.catalog.exception.InvalidProductTypeException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Invalid product Id Exception occured")
	@ExceptionHandler(InvalidProductIdException.class)
	public void handleInvalidProductIdException() {
		logger.error("Invalid product id exception is thrown.");
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Invalid product Type Exception occured")
	@ExceptionHandler(InvalidProductTypeException.class)
	public void handleInvalidProductTypeException() {
		logger.error("Invalid product type exception is thrown.");
	}		
	
}
