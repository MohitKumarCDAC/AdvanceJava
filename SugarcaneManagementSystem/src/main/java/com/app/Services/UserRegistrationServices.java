package com.app.Services;

import java.util.List;

import com.app.DTO.UserRegistrationDto;
import com.app.entity.Role;

public interface UserRegistrationServices {
		UserRegistrationDto registerUser(UserRegistrationDto registerUser);
		 List<UserRegistrationDto> getUsersByRole(Role role);
		
}
