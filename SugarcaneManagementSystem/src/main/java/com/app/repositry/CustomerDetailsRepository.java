package com.app.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
	CustomerDetails findByAadharNumber(String aadharNumber);
}
