package com.app.DTO;

import com.app.entity.Address;
import com.app.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDto {
	
    
   
    private String Name;
    
    private String Email;
   
    private String ContactNumber;
    
    private Role Role;

    private String AadharNumber;
   
    private String Password;

    private Address address;

}
