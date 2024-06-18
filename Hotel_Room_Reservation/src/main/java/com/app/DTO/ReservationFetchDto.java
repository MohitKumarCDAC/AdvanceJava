package com.app.DTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReservationFetchDto {
	
	private Long reservationID;
	
	     private String guestName;

	    private LocalDate checkInDate;

	    private LocalDate checkOutDate;

	    private Long roomId;

	    private double totalPrice;
}
