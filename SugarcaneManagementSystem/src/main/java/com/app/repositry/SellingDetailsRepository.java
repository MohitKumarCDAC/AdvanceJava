package com.app.repositry;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.CustomerDetails;
import com.app.entity.SellingDetails;

@Repository
public interface SellingDetailsRepository extends JpaRepository<SellingDetails, Long> {
	 List<SellingDetails> findByCustomer(CustomerDetails customer);
	    List<SellingDetails> findBySellingDate(LocalDate sellingDate);
}
