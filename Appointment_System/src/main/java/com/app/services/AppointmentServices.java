package com.app.services;

import java.util.List;

import com.app.Dto.AppointmentDto;
import com.app.entity.Appointment;

public interface AppointmentServices {
	
	AppointmentDto createAppointment(AppointmentDto appointmentDTO);
//    List<Appointment> getUpcomingAppointments(Long patientId);
//    String cancelAppointment(Long appointmentId);
}
