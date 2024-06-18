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

import com.app.DTO.RecipeDto;
import com.app.service.RecipeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

	
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping
	@Operation(description = "Get All Recipe...")
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.getAllRecipe());
	}
	
	@GetMapping("/{id}")
	@Operation(description = "Get Recipe By id")
	public ResponseEntity<?> getRecipeByid(@PathVariable Long id)
	{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(recipeService.getRecipeByid(id));
					
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	@Operation(description ="Delete Recipe by id...")
	public ResponseEntity<?> deleteRecipe(@PathVariable Long id)
	{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(recipeService.deleteByid(id));
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	@PostMapping
	@Operation(description = "Post(add) Data into db..")
	public ResponseEntity<?> addResponce(@RequestBody RecipeDto recipedto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.addRecipe(recipedto));
	}
	
	@PutMapping("/{id}")
	@Operation(description = "Update Record.....")
	public ResponseEntity<?> updateRecipe(@PathVariable Long id, @RequestBody RecipeDto recipeDto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.updateRecipe(id, recipeDto));
	}
	
}
