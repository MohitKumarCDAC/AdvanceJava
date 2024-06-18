package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="recipe")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="recipe_id")
	private Long RecipeId;
	@Column(length=20)
	private String title;
	@Column(length=200)
	private String description;
	@Column(length=50)
	private String ingredients;
	@Column(length=100)
	private String instruction;
	
	@Enumerated(EnumType.STRING)
	@Column(name="difficuilty_level")
	private DifficultyLevel difficultyLevel;
	
	@Enumerated(EnumType.STRING)
	@Column(name="cusine_type")
	private CuisineType cusineType;
	
	
	@Column(name="creatuin_date")
	private LocalDate CreationDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Author author;

	public Recipe(String title, String description, String ingredients, String instruction,
			DifficultyLevel difficultyLevel, CuisineType cusineType, Author author) {
		super();
		this.title = title;
		this.description = description;
		this.ingredients = ingredients;
		this.instruction = instruction;
		this.difficultyLevel = difficultyLevel;
		this.cusineType = cusineType;
		this.author = author;
		this.CreationDate=LocalDate.now();
	}
	
	
}
