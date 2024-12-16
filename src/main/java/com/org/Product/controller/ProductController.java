package com.org.Product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.Product.dto.Product;
import com.org.Product.service.ProductService;


@RestController
public class ProductController {

	
	@Autowired
	ProductService service;
	
	
	@PostMapping("/products")
	public ResponseEntity<Object> saveProduct(@RequestBody Product product){
		return service.saveProduct(product);
	}
	
	
	@PostMapping("/products/many")
	public ResponseEntity<Object> saveProducts(@RequestBody List<Product> products){
		return service.saveProducts(products);
	}
	
	//Fetch All Products
		@GetMapping("/products")
		public ResponseEntity<Object> fetchAllProducts(){
			return service.fetchAllProducts();
		}
		
		//Fetch Product By Id
		@GetMapping("/products/{id}")
		public ResponseEntity<Object> fetchById(@PathVariable int id){
			return service.fetchById(id);
		}
		
		@GetMapping("/products/name/{name}")
		public ResponseEntity<Object> fetchByName(@PathVariable String name){
			return service.fetchByName(name);
		}
		
		@GetMapping("/products/price/greater/{price}")
		public ResponseEntity<Object> fetchByPriceGreater(@PathVariable double price){
			return service.fetchByPriceGreater(price);
		}
		
		@GetMapping("/products/stock/{min}/{max}")
		public ResponseEntity<Object> fetchByStockBetween(@PathVariable int min,@PathVariable int max){
			return service.fetchByStockBetween(min,max);
		}
		
}
