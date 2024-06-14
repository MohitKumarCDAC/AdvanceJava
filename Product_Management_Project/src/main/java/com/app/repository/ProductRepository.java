package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
//JpaRepository is a Interface 
	//its has a lot of methods and its very handy to work 
}
