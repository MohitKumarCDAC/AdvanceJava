package com.app.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Role;
import com.app.entity.UserRegistration;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Long> {
	 UserRegistration findByAadharNumber(String aadharNumber);
	 List<UserRegistration> findByRole(Role role);
}
