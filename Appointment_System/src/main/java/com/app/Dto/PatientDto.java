package com.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class PatientDto{
    
	private Long id;
	private String patientName;
	
	private String email;
	
	private String password;
	
	private String contact_no;
	
	private Long AdharNumber;
}
