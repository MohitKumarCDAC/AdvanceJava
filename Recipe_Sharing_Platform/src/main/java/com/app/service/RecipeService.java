package com.app.service;

import java.util.List;

import com.app.DTO.RecipeDto;
import com.app.entity.Recipe;

public interface RecipeService {
  
	List<RecipeDto> getAllRecipe();
	RecipeDto getRecipeByid(Long id);
	RecipeDto addRecipe(RecipeDto recipeDto);
	Recipe deleteByid(Long id);
	RecipeDto updateRecipe(Long id,RecipeDto recipedto);
}
