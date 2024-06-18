package com.app.DTO;

import java.time.LocalDate;

import com.app.Entity.Room;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDto {

	

	private String guestName;

	private LocalDate checkInDate;

	private LocalDate checkOutDate;
	
	private Long roomId;

}
