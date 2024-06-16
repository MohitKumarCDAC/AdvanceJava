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

import com.app.Dto.DoctorDto;
import com.app.services.DoctorService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/doctors")
public class DoctorControler {

	@Autowired
	private DoctorService doctorservice;
	
	@PostMapping
	@Operation(description = "Add doctor...")
	
	public ResponseEntity<?> addDoctor(@RequestBody DoctorDto doctor)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(doctorservice.addDoctor(doctor));
	}
	
	@GetMapping
	@Operation(description = "Get All Doctors...")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(doctorservice.getAllDoctorList());
	}
	
	@GetMapping("/{id}")
	@Operation(description = "Doctor find by id....")
	public ResponseEntity<?> getDoctorByid(@PathVariable Long id)
	{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(doctorservice.getDoctorByID(id));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@Operation(description = "delete doctor by id.....")
	public ResponseEntity<?> deleteByid(@PathVariable Long id)
	{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(doctorservice.deleteDoctorById(id));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	
	
	
}
