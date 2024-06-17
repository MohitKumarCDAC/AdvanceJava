package com.app.services;

import java.util.List;

import com.app.Dto.AppointmentDto;
import com.app.entity.Appointment;

public interface AppointmentServices {
	
	AppointmentDto createAppointment(AppointmentDto appointmentDTO);
    List<AppointmentDto> getAllAppointment();
    AppointmentDto updateAppointment(Long id, AppointmentDto appointmentDto);
    AppointmentDto getAppointment(Long id);
   String deleteAppointment(Long id);
 
}
