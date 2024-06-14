package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exception.ProductNotFoundException;
import com.app.dtos.ApiResponses;
import com.app.entity.Product;
import com.app.repository.ProductRepository;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productrepository;
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productrepository.findAll();
	}

	@Override
	public Product addNewProduct(Product newProduct) {
		// TODO Auto-generated method stub
		return productrepository.save(newProduct);
	}

	@Override
	public Product find(Long id) {
		
		return productrepository.findById(id)
				.orElseThrow(()->new ProductNotFoundException("Product Not Found in database"));
	}
	
	@Override
	
	public long countAll() {
		
		return productrepository.count();
	}

	@Override
	public ApiResponses deleteProduct(Long id) {
		Product product=productrepository.findById(id)
				.orElseThrow(()->new ProductNotFoundException("invalid id!!"));
		productrepository.delete(product);
		return new ApiResponses("Product deleted:"+id);
	}

	@Override
	public ApiResponses updateProductDetails(Long id, Product product) {
		String msg="Updation failed...";
		//validate
		if(productrepository.existsById(id))
		{
			//category is valid
			productrepository.save(product);
			msg="Update category details....";
		}else
		{
			throw new ProductNotFoundException("invalid product id..");
			
		}
		return new ApiResponses(msg);
		
	}

	
	

	

	
 
	

}
