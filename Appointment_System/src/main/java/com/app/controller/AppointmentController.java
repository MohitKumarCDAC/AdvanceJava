package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.AppointmentDto;
import com.app.services.AppointmentServices;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {
  @Autowired
  private AppointmentServices services;
  
  @GetMapping
  @Operation(description = "Get All AppointMent")
  public ResponseEntity<?> getAllAppointment()
  {
	  return ResponseEntity.status(HttpStatus.OK).body(services.getAllAppointment());
  }
  
  @PostMapping
  @Operation(description = "Create Appointment")
  public ResponseEntity<?> addAppointment(@RequestBody @Valid AppointmentDto appointmentDto)
  {
	  return ResponseEntity.status(HttpStatus.OK).body(services.createAppointment(appointmentDto));
  }
  
  @GetMapping("/{id}")
  @Operation(description = "Get Appointmant By id")
  public ResponseEntity<?> getAppointmentByID(@PathVariable Long id)
  {
	  try {
		  return ResponseEntity.status(HttpStatus.OK).body(services.getAppointment(id));
	  }catch (RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
  }
  
  @DeleteMapping("/{id}")
  @Operation(description = "Delete Appointment..")
  public ResponseEntity<?> deleteAppointment(@PathVariable Long id)
  {
	  try {
		  return ResponseEntity.status(HttpStatus.OK).body(services.deleteAppointment(id));
	  }catch (RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
  }
  
  @PutMapping("/{id}")
  @Operation(description = "Update AppointMent")
  public ResponseEntity<?> updateAppointMent(@PathVariable Long id,@RequestBody AppointmentDto appointmentDto)
  {
	  return ResponseEntity.status(HttpStatus.OK).body(services.updateAppointment(id, appointmentDto));
  }
  
}
