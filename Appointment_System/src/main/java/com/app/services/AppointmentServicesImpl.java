package com.app.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.AppointmentDto;
import com.app.Exception.DoctorNotFoundException;
import com.app.Exception.PatientNotFoundException;
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
	    private PatientRepository patientRepository;

	    @Autowired
	    
	    private DoctorRepository doctorRepository;
	    @Autowired
	    private ModelMapper modelmapper;

	@Override
	public AppointmentDto createAppointment(AppointmentDto appointmentDTO) {
		Patient patient = patientRepository.findByPatientName(appointmentDTO.getPatientName());
        if (patient == null) {
            throw new PatientNotFoundException("Patient name not found!!!");
        }

        Doctor doctor = doctorRepository.findByDoctorName(appointmentDTO.getDoctorName());
        if (doctor == null) {
            throw new DoctorNotFoundException("doctor not found !!!!!!");
        }

//        if (appointmentRepository.existsByDoctorIdAndDateAndTime(doctor.getId(), appointmentDTO.getDate(), appointmentDTO.getTime())) {
//            throw new DoctorNotFoundException("Doctor is busy this time pls select another one...");
//        }

        Appointment appointment=modelmapper.map(appointmentDTO,Appointment.class);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        
        appointmentRepository.save(appointment);
        // Map Appointment entity back to AppointmentDto and return it
        return modelmapper.map(appointment, AppointmentDto.class);
		
	}

//	@Override
//	public List<Appointment> getUpcomingAppointments(Long patientId) {
//		// TODO Auto-generated method stub
//		return appointmentRepository.findByPatientIdAndDateGreaterThanEqual(patientId, LocalDate.now());
//	}

//	@Override
//	public String cancelAppointment(Long appointmentId) {
//		if(appointmentRepository.existsById(appointmentId)) {
//			appointmentRepository.deleteById(appointmentId);
//			return "appointment: cancel successful";
//		}else {
//			return "Appointment not found";
//		}
//		
//	}

}
