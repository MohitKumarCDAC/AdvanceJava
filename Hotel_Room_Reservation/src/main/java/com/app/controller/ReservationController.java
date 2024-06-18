package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.ReservationDto;
import com.app.services.ReservationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	
	@GetMapping
	@Operation(description = "Get ALL Reservation")
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.status(HttpStatus.OK).body(reservationService.getAllReservation());
	}
	
	@GetMapping("/{id}")
	@Operation(description = "Get By id")
	public ResponseEntity<?> getReservationByid(@PathVariable Long id)
	{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(reservationService.findReservationByID(id));
		}catch (RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping
	@Operation(description = "Add Reservation....")
	public ResponseEntity<?> addReservation(@RequestBody ReservationDto reservationdto)
	{
		try {
		return ResponseEntity.status(HttpStatus.OK).body(reservationService.addReservation(reservationdto));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@Operation(description = "cancle reservation...")
	public ResponseEntity<?> cancleReser(@PathVariable Long id)
	{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(reservationService.cancleReservation(id));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	
}
