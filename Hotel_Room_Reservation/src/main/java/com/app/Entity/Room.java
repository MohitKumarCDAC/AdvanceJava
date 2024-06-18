package com.app.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name="room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomId;
	@Column(name="room_number",length = 10,nullable = false)
	private String roomNumber;
	@Enumerated(EnumType.STRING)
	@Column(name="room_type" ,nullable = false)
	private RoomType roomType;
	@Column(nullable = false)
	@DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
	private double price;
	@Column(nullable = false,columnDefinition = "TINYINT(1)")
	private boolean availability;
	
	

}
