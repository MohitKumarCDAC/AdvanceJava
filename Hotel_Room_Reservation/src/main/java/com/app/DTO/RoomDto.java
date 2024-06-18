package com.app.DTO;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;

import com.app.Entity.RoomType;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class RoomDto {
	
	private Long roomId;
	
	private String roomNumber;
	
	private RoomType roomType;
	
	private double price;
	
	private boolean availability;

}
