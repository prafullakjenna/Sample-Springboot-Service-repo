package com.globomart.product.catalog.integration.test;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.json.JSONException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globomart.product.catalog.application.ProductCatalogApplication;
import com.globomart.product.catalog.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCatalogApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCatalogControllerITest {
	
	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testCreateProduct() throws JSONException {
		Product product = new Product("TV", "LED", "SMART", "SONY", new BigDecimal(70120.99));		
		ResponseEntity<String> response = restTemplate.postForEntity(createServiceURL("/catalog/createProduct"),
																		product, String.class);
		 
		assertThat(valueOf(HttpStatus.OK.value())).isEqualTo(valueOf(response.getStatusCodeValue()));		
		
	}
	
	@Test
	public void testGetProductByType() throws JSONException, JsonParseException, JsonMappingException, IOException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createServiceURL("/catalog/getProducts?type=SMART"),
				HttpMethod.GET, entity, String.class);

		ObjectMapper mapper = new ObjectMapper();
		List<Product> products = mapper.readValue(response.getBody(), 
								 mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
		
		Product product = products.get(0);
		
		assertThat(product.getId()).isEqualTo(1L);
		assertThat(product.getName()).isEqualTo("TV");
		assertThat(product.getDescription()).isEqualTo("LED");
		assertThat(product.getType()).isEqualTo("SMART");
		assertThat(product.getModel()).isEqualTo("SONY");
	}
	
	@Test
	public void testRemove() {
		ResponseEntity<Void> response = restTemplate.exchange(createServiceURL("/catalog/deleteProduct"), 
										HttpMethod.DELETE, null, Void.class, new Long(1));
		
		assertThat(response.getStatusCodeValue()).isEqualTo(400);

	}
	
	
	private String createServiceURL(String uri) {
		return "http://localhost:" + port + uri;
	}	
}
