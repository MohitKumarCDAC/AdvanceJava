package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.Apiresponse;
import com.app.Dto.PatientDto;
import com.app.Exception.PatientNotFoundException;
import com.app.entity.Patient;
import com.app.repository.PatientRepository;
@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private ModelMapper modelmapper;
	
	
	@Override
	public PatientDto insertData(PatientDto patientDto) {
		System.out.println("Received in Service: " + patientDto);
		Patient patient=modelmapper.map(patientDto, Patient.class);
		 System.out.println("Mapped Entity: " + patient);
		Patient p=patientRepo.save(patient);
		return modelmapper.map(p, PatientDto.class);
	}
		

	@Override
	public List<PatientDto> getAllPatients() {
		
		return patientRepo.findAll()
				.stream()
				.map(patient->modelmapper.map(patient,PatientDto.class))
				.collect(Collectors.toList());
	}


	@Override
	public PatientDto getByID(Long id) {
		
		Patient patient= patientRepo.findById(id).
				orElseThrow(()-> new PatientNotFoundException("Id mismatch....."));
		return modelmapper.map(patient, PatientDto.class);
	}


	@Override
	public PatientDto deleteByID(Long id) {
		Patient patient=patientRepo.findById(id).
				orElseThrow(()->new PatientNotFoundException("Patient not Found...."));
		patientRepo.deleteById(id);
		return modelmapper.map(patient, PatientDto.class);
	}


	@Override
	public PatientDto updatePatientRecord(Long id, PatientDto NewPatient) {
		String msg="Updation Failed....";
		Patient patient=modelmapper.map(NewPatient, Patient.class);
		if(patientRepo.existsById(id))
		{
			patient.setId(id);
			patientRepo.save(patient);
			return modelmapper.map(patient, PatientDto.class);
		}
		throw new PatientNotFoundException("patient id not found");
	}

}
