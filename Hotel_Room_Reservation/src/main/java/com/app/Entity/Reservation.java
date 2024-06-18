package com.app.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationID;
	
	@Column(name="guest_name",length = 50,nullable = false)
	private String guestName;
	
	@Column(name="check_in_date")
	private LocalDate checkInDate;
	
	@Column(name="check_out_date")
	private LocalDate checkOutDate;
	
	@Column(name="total_price")
	private double totalPrice;
	

	@ManyToOne
	@JoinColumn(name="room_id")
	private Room room;
}
