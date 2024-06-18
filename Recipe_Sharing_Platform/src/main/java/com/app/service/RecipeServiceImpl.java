package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.RecipeDto;
import com.app.Exception.AuthorNotFoundException;
import com.app.Exception.RecipeNotFoundException;
import com.app.entity.Author;
import com.app.entity.Recipe;
import com.app.repository.AuthorRepository;
import com.app.repository.RecipeRepository;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<RecipeDto> getAllRecipe() {
		return recipeRepository.findAll().stream().map(recipe->mapper.map(recipe, RecipeDto.class)).
		collect(Collectors.toList());
		
	}

	@Override
	public RecipeDto getRecipeByid(Long id) {
	  Recipe recipe=recipeRepository.findById(id).orElseThrow(()->new RecipeNotFoundException("Id not Found.."));
		return mapper.map(recipe, RecipeDto.class);
	}

	@Override
	public RecipeDto addRecipe(RecipeDto recipeDto) {
		Recipe recipe=mapper.map(recipeDto, Recipe.class);
		Author author=authorRepository.findById(recipeDto.getUserId())
				.orElseThrow(()->new AuthorNotFoundException("Author id not found..."));
		
		recipe.setAuthor(author);
		recipe=recipeRepository.save(recipe);
		RecipeDto recipeDTO=mapper.map(recipe, RecipeDto.class);
		recipeDTO.setUserId(recipe.getAuthor().getUserId());
		return recipeDTO;
	}

	@Override
	public Recipe deleteByid(Long id) {
		Recipe recipe=recipeRepository.findById(id).
				orElseThrow(()->new RecipeNotFoundException("recipe id does not found.."));
		recipeRepository.deleteById(id);
		return recipe;
	}

	@Override
	public RecipeDto updateRecipe(Long id, RecipeDto recipedto) {
		String msg="Error in Updation...";
		Recipe recipe=mapper.map(recipedto, Recipe.class);
		if(recipeRepository.existsById(id))
		{
			recipe.setRecipeId(id);
			recipeRepository.save(recipe);
			msg="recipe Updated...";
			return mapper.map(recipe, RecipeDto.class);
		}
		throw new RecipeNotFoundException(msg);
	}
	
	
}
