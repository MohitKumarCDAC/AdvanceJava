package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="author")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long UserId;
@Column(length=30)
	private String name;
}
