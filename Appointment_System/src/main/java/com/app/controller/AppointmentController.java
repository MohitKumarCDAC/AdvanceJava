package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.AppointmentDto;
import com.app.services.AppointmentServices;


@RestController
@RequestMapping("/appointment")
public class AppointmentController {
  @Autowired
  private AppointmentServices services;
  
  @PostMapping("/create")
  public ResponseEntity<?> createAppointment(@RequestBody AppointmentDto appointmentDto) {
      try {
          AppointmentDto createdAppointment = services.createAppointment(appointmentDto);
          return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
      } catch (IllegalArgumentException e) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
      }
  }
  
//  @GetMapping("/upcoming/{patientId}")
//  public List<Appointment> viewUpcomingAppointments(@PathVariable Long patientId) {
//      return services.getUpcomingAppointments(patientId);
//  }
//  
//  @DeleteMapping("/cancel/{appointmentID}")
//  public String cancelAppointment(@PathVariable Long appointmentId) {
//      return services.cancelAppointment(appointmentId);
//  }
}
