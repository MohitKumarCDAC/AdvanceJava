package com.app.Services;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.UserRegistrationDto;
import com.app.entity.UserRegistration;
import com.app.repositry.UserRegistrationRepository;

@Service
@Transactional
public class UserRegistrationImpl implements UserRegistrationServices {
	
	@Autowired
	private UserRegistrationRepository userRegisRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserRegistrationDto registerUser(UserRegistrationDto registerUser) {
		//convert Dto to entity
		UserRegistration userRegis=mapper.map(registerUser,UserRegistration.class);
		UserRegistration reg=userRegisRepo.save(userRegis);				
		return mapper.map(reg, UserRegistrationDto.class);
	}

}
