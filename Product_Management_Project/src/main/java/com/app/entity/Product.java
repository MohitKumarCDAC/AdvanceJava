package com.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ch.qos.logback.core.subst.Token.Type;

@Entity
@Table(name="product")
public class Product extends BaseEntity{
	
	@Column(length=20)
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Column(name="product_name",length = 30)
	private String productName;
	
	@Column(name="available_Quantity")
	private int AvailableQunatity;
	
	@Column(name="product_price")
	private double productPrice;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Category category, String productName, int availableQunatity, double productPrice) {
		super();
		this.category = category;
		this.productName = productName;
		AvailableQunatity = availableQunatity;
		this.productPrice = productPrice;
	}

	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getAvailableQunatity() {
		return AvailableQunatity;
	}

	public void setAvailableQunatity(int availableQunatity) {
		AvailableQunatity = availableQunatity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public LocalDate getCreationDate() {
		// TODO Auto-generated method stub
		return super.getCreationDate();
	}

	@Override
	public void setCreationDate(LocalDate creationDate) {
		// TODO Auto-generated method stub
		super.setCreationDate(creationDate);
	}

	@Override
	public LocalDateTime getUpdationDate() {
		// TODO Auto-generated method stub
		return super.getUpdationDate();
	}

	@Override
	public void setUpdationDate(LocalDateTime updationDate) {
		// TODO Auto-generated method stub
		super.setUpdationDate(updationDate);
	}

	@Override
	public String toString() {
		return "Product [id="+getId()+"category=" + category + ", productName=" + productName + ", AvailableQunatity="
				+ AvailableQunatity + ", productPrice=" + productPrice + "]";
	}

	
	
	
	
	
	
}
