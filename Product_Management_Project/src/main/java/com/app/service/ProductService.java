package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dtos.ApiResponses;
import com.app.entity.Product;

public interface ProductService {
 List<Product> getAllProduct();
 Product addNewProduct(Product newProduct);
 ApiResponses deleteProduct(Long id);
 long countAll();
Product find(Long id);
ApiResponses updateProductDetails(Long id,Product product);
 
}
