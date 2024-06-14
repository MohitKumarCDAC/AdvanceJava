package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Exception.ProductNotFoundException;
import com.app.dtos.ApiResponses;
import com.app.entity.Category;
import com.app.entity.Product;
import com.app.repository.ProductRepository;
import com.app.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	
	public ProductController() {
		System.out.println("in product controller!");
	}
	
	@GetMapping
	@Operation(description = "Get All products...")
	public List<Product> getProduct(){
		return productservice.getAllProduct();
	}
	@PostMapping
	@Operation(description = "Add Product....")
	public Product addNewProduct(@RequestBody Product product)
	{
		return productservice.addNewProduct(product);
	}
	@GetMapping("/{id}")
	@Operation(description = "Get Category Details by id")
	public ResponseEntity<?> getProductDetails(@PathVariable Long id)
	{
		System.out.println("in get category:"+id);
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(productservice.find(id));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponses(e.getMessage()));
		}
	}

	
	@DeleteMapping("/{id}")
	@Operation(description = "Delete Product....")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id)
	{
		System.out.println("in delete"+id);
		return ResponseEntity.ok(productservice.deleteProduct(id));
	}
	
	@GetMapping("/count")
	@Operation(description = "Count All Products...")
	public long count()
	{
		return productservice.countAll();
	}
	
	//for update productDetails
	@PutMapping("/{id}")
	@Operation(description = "update category details")
	public ResponseEntity<?> updateproduct(@PathVariable Long id,@RequestBody Product product)
	{
		System.out.println("in update product:"+id+" "+product);
		return ResponseEntity.status(HttpStatus.OK).
				body(productservice.updateProductDetails(id, product));
	}
}
