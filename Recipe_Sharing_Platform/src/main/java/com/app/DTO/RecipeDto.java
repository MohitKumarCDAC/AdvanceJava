package com.app.DTO;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.entity.CuisineType;
import com.app.entity.DifficultyLevel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDto {

	private Long RecipeId;
	private String title;
	private String description;
	private String ingredients;
	private String instruction;
	private DifficultyLevel difficultyLevel;
	private CuisineType cusineType;
	private LocalDate CreationDate;
	private Long UserId;
}
