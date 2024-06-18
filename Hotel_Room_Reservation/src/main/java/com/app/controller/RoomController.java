package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.RoomDto;
import com.app.services.RoomService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/room")
public class RoomController {

	
	@Autowired
	private RoomService roomservice;
	
	@PostMapping
	@Operation(description = "Add room in database.........")
	public ResponseEntity<?> addroom( @Valid @RequestBody RoomDto room)
	{
		return ResponseEntity.status(HttpStatus.OK).body(roomservice.addRoom(room));
	}
	
	@PutMapping("/{id}")
	@Operation(description = "Update Room Record........")
	public ResponseEntity<?> updateRecord(@PathVariable Long id,@RequestBody RoomDto roomdto){
		return ResponseEntity.status(HttpStatus.OK).body(roomservice.updateRoom(id, roomdto));
	}
	
	@GetMapping
	@Operation(description = "get all available rooms")
	public ResponseEntity<?> findAvalibleRoom()
	{
		return ResponseEntity.status(HttpStatus.OK).body(roomservice.getAvailable());
	}
	
}
