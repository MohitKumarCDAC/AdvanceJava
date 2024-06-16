package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@ToString(exclude = "password")
@Entity
@Table(name="patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="patient_name",length = 30)
	private String patientName;
	@Column(length = 30)
	private String email;
	@Column(length = 13)
	private String password;
	@Column(length = 13)
	private String contact_no;
	@Column(length=20)
	private Long AdharNumber;
	
	//one patient many appointment
	@OneToMany(mappedBy ="patient",cascade = CascadeType.ALL ,fetch = FetchType.EAGER )
	private List<Appointment> appointments;
	
}
