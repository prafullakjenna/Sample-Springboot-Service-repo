package com.globomart.product.catalog.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
    
    @Column
	private String name;
    
    @Column
	private String description;
    
    @Column
	private String type;
    
    @Column
	private String model;
    
    @Column
	private BigDecimal price;
	
	public Product() {}
	
	public Product(final String name, final String description, 
				   final String type, final String model, final BigDecimal price) {
		
		this.name = name;
		this.description = description;
		this.type = type;
		this.model = model;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(final String description) {
		this.description = description;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(final String type) {
		this.type = type;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(final String model) {
		this.model = model;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(final BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("Product [id=%d, name=%s, model=%s, type=%s", id, name, model, type);
	}
}
