package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="appointment")
public class Appointment extends BaseEntity {

	@ManyToOne
	@JoinColumn(name="patient_id")
	//here we define forign key with the help of Primary key
		//and establish relation
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")//here we define forign key with the help of Primary key
	//and establish relation
	private Doctor doctor;
	@Column(name = "appointment_date_time",unique = true)
	private LocalDateTime appointmentDateTime;
	
}
