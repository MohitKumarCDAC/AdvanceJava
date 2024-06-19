package com.app.entity;

import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

public class BaseEntity {

	@UpdateTimestamp
	private LocalDate updateDateTime;
	
}
