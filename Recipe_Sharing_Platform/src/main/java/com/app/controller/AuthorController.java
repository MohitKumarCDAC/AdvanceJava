package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Author;
import com.app.service.AuthorService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorservice;
	
	@PostMapping
	@Operation(description = "Author Add..")
	public ResponseEntity<?> addauthor(@RequestBody Author author)
	{
		return ResponseEntity.status(HttpStatus.OK).body(authorservice.addAuthor(author));
	}
	
	@GetMapping
	@Operation(description = "get All author")
	public ResponseEntity<?> getAllAuthor()
	{
		return ResponseEntity.status(HttpStatus.OK).body(authorservice.getAllAuthor());
	}
	
}
