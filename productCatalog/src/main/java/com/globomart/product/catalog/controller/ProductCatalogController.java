package com.globomart.product.catalog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.product.catalog.exception.InvalidProductIdException;
import com.globomart.product.catalog.exception.InvalidProductTypeException;
import com.globomart.product.catalog.model.Product;
import com.globomart.product.catalog.service.ProductCatalogService;

@RestController
public class ProductCatalogController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductCatalogService productCatalogService;
	
	
	@RequestMapping(value="/catalog/createProduct", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createProduct(@RequestBody Product product) {
		
		logger.debug("Inside create product method.." +product.toString());
		
		productCatalogService.createProduct(product);
		
	}
	
	@RequestMapping(value="/catalog/getProducts",  method = RequestMethod.GET )
	public List<Product> getProducts(@RequestParam String type) throws InvalidProductTypeException {
		logger.debug("Inside getProducts method..");
		
		return productCatalogService.getProducts(type);
	}	
	
	
    @RequestMapping(value = "/catalog/deleteProduct", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.GONE)
    public void removeProduct(@RequestParam Long id) throws InvalidProductIdException {
    	logger.debug("Inside removeProduct method..");
    	
    	productCatalogService.removeProduct(id);
    	
    }
    
}
