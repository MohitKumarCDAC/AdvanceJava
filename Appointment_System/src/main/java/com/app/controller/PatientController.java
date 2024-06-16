package com.app.controller;

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

import com.app.Dto.PatientDto;
import com.app.entity.Patient;
import com.app.services.PatientService;

import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("/patients")
public class PatientController {

@Autowired
private PatientService pservice;

@PostMapping
public ResponseEntity<?> addnewPatient(@RequestBody PatientDto patientDto)
{
	System.out.println("in Patient"+patientDto);
	return ResponseEntity.status(HttpStatus.CREATED).body(pservice.insertData(patientDto));
}


@GetMapping
@Operation(description = "Get all Patient Details")
public ResponseEntity<?> listAllPatients(){
	return ResponseEntity.ok(pservice.getAllPatients());
}

@GetMapping("/{id}")
@Operation(description = "Get by id....")
public ResponseEntity<?> getPatientById(@PathVariable Long id)
{
	try {
		return ResponseEntity.status(HttpStatus.OK).body(pservice.getByID(id));
	}catch (RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}

@DeleteMapping("/{id}")
@Operation(description = "Patient delete by Id...")
public ResponseEntity<?> deletePatient(@PathVariable Long id)
{
	try {
		return ResponseEntity.status(HttpStatus.OK).body(pservice.deleteByID(id));
	}catch (RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}

@PutMapping("/{id}")
@Operation(description = "Update Patient Data.....")
public ResponseEntity<?> updateRescord(@PathVariable Long id,@RequestBody Patient patient)
{
	return ResponseEntity.status(HttpStatus.OK).body(pservice.updatePatientRecord(id, patient));
}
	
}
