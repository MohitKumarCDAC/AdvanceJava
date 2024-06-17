package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.AppointmentDto;
import com.app.Exception.AppointmentException;
import com.app.Exception.DoctorNotFoundException;
import com.app.entity.Appointment;
import com.app.entity.Doctor;
import com.app.entity.Patient;
import com.app.repository.AppointmentRepository;
import com.app.repository.DoctorRepository;
import com.app.repository.PatientRepository;
@Service
@Transactional
public class AppointmentServicesImpl implements AppointmentServices {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	

	@Override
	public AppointmentDto createAppointment(AppointmentDto appointmentDTO) {
		Doctor doctor=doctorRepository.findByDoctorName(appointmentDTO.getDoctor().getDoctorName());
		Patient patient=patientRepository.findByPatientName(appointmentDTO.getPatient().getPatientName());
		
		Appointment appointment=modelmapper.map(appointmentDTO, Appointment.class);
		if(doctor == null)
			throw new AppointmentException("Please enter doctor and patient name");
		int size = getAllAppointment().stream().filter(
				a -> !a.getAppointmentDateTime().plusMinutes(30).isBefore(appointmentDTO.getAppointmentDateTime())
					&& !a.getAppointmentDateTime().isAfter(appointmentDTO.getAppointmentDateTime().plusMinutes(30))
						&& a.getDoctor().equals(appointmentDTO.getDoctor()))
				.collect(Collectors.toList()).size();
		if (size > 0)
			throw new AppointmentException("Apointment already Booked");
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		System.out.println(appointment);
		appointment = appointmentRepository.save(appointment);
		return modelmapper.map(appointment, AppointmentDto.class);
		
	}

	@Override
	public List<AppointmentDto> getAllAppointment() {
		return appointmentRepository.findAll().stream().map(entity -> modelmapper.map(entity, AppointmentDto.class))
				.collect(Collectors.toList());
		
	}


	@Override
	public AppointmentDto updateAppointment(Long id, AppointmentDto appointmentDto) {
		Appointment appointment=modelmapper.map(appointmentDto, Appointment.class);
		appointment.setId(id);
		
		Doctor doctor=doctorRepository.findByDoctorName(appointmentDto.getDoctor().getDoctorName());
		Patient patient=patientRepository.findByPatientName(appointmentDto.getPatient().getPatientName());
		
		if(doctor ==null)
			throw new AppointmentException("Please Enter Patient and Doctor Name");
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		
		appointmentRepository.save(appointment);
		
		return modelmapper.map(appointment, AppointmentDto.class);
	}

	@Override
	public AppointmentDto getAppointment(Long id) {
		Appointment appointment=appointmentRepository.findById(id)
				.orElseThrow(()->new AppointmentException("Appointment ID not found ....."));
		return modelmapper.map(appointment, AppointmentDto.class);
	}

	@Override
	public String deleteAppointment(Long id) {
		if(appointmentRepository.existsById(id)) {
			appointmentRepository.deleteById(id);
		}
		else
		{	
			throw new AppointmentException("Appointment id does not found");
			}
		return "Appointment delete sussessfully.....";
		
		
	}
	
	
}
