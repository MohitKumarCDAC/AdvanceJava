package com.app.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//	 List<Appointment> findByPatientIdAndDateGreaterThanEqual(Long patientId, LocalDate date);
//	    boolean existsByDoctorIdAndDateAndTime(Long doctorId, LocalDate date, LocalTime time);
	
}
