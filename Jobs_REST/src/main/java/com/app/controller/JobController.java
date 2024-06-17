package com.app.controller;

import org.modelmapper.ModelMapper;
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

import com.app.DTO.JobDTO;
import com.app.Entity.Jobs;
import com.app.services.JobService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/jobs")
public class JobController {

	
	@Autowired
	private JobService services;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	@Operation(description = "Add new Job")
	public ResponseEntity<?> addnewJob(@RequestBody JobDTO job)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(services.addnewJob(job));
	}
	
	@GetMapping
	@Operation(description = "Get All Jobs....")
	public ResponseEntity<?> getAllJobs()
	{
		return ResponseEntity.status(HttpStatus.OK).body(services.getAllJobs());
	}
	
	@GetMapping("/{id}")
	@Operation(description = "Search Job By JobID")
	public ResponseEntity<?> getJobBYId(@PathVariable Long id)
	{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(services.getJobByID(id));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	@PutMapping("/{id}")
	@Operation(description = "Update Jobs...")
	public ResponseEntity<?> updateJob(@PathVariable Long id,@RequestBody JobDTO jobdto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(services.updateJob(id, jobdto));
	}
	@DeleteMapping("/{id}")
	@Operation(description = "Delete Job..")
	public ResponseEntity<?> deleteRecord(@PathVariable Long id)
	{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(services.deleteJob(id));
		}catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
