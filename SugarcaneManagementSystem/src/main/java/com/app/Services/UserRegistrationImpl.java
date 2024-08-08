package com.app.Services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.UserRegistrationDto;
import com.app.entity.Role;
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
        // Convert DTO to entity
        UserRegistration userRegis = mapper.map(registerUser, UserRegistration.class);
        UserRegistration reg = userRegisRepo.save(userRegis);
        return mapper.map(reg, UserRegistrationDto.class);
    }

    @Override
    public List<UserRegistrationDto> getUsersByRole(Role role) {
        List<UserRegistration> users = userRegisRepo.findByRole(role);
        return users.stream()
                    .map(user -> mapper.map(user, UserRegistrationDto.class))
                    .collect(Collectors.toList());
    }
}
