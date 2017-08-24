package com.globomart.product.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globomart.product.catalog.model.Product;

@Repository
public interface ProductCatalogRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByType(String type);
	
}
