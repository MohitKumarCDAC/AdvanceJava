package com.app.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDto {
	
	private Long id;
	
	
	private String doctorName;
	
	
	private String specialization;
}
