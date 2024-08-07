package com.app.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.UserRegistration;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Long> {
	 UserRegistration findByAadharNumber(String aadharNumber);
}
