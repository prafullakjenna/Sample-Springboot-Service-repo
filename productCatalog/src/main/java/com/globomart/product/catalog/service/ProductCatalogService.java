package com.globomart.product.catalog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.globomart.product.catalog.exception.InvalidProductIdException;
import com.globomart.product.catalog.exception.InvalidProductTypeException;
import com.globomart.product.catalog.model.Product;
import com.globomart.product.catalog.repository.ProductCatalogRepository;

@Component
public class ProductCatalogService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	private ProductCatalogRepository repository;
	
	public void createProduct(final Product product) {
		logger.debug("Inside createProduct() method..");
		
		repository.save(product);
		
	}
	
	public List<Product> getProducts(final String productType) throws InvalidProductTypeException {
		
		logger.debug("Inside getProduct() method..");
		
		if (!StringUtils.isEmpty(productType)) {
						
			return repository.findByType(productType);
		}
		
		throw new InvalidProductTypeException("The product type is invalid..");
	}
	
	
	public void  removeProduct(final Long productId) throws InvalidProductIdException {
		
		logger.debug("Inside remove product method..");
		
		if (!StringUtils.isEmpty(productId)) {
			
			repository.delete(productId);
			
		} else {
			
			throw new InvalidProductIdException("The product id is invalid..");
			
		}
		
	}	

}
