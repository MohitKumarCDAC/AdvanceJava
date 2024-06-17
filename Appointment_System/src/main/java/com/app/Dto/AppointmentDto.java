package com.app.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class AppointmentDto extends BAseDto{
//    private LocalTime time;
    @NotNull(message = "Doctor name CANNOT be NULL")
	private DoctorDto doctor;
	@NotNull(message = "Patient name CANNOT be NULL")
	private PatientDto patient;
	private LocalDateTime appointmentDateTime;
}
