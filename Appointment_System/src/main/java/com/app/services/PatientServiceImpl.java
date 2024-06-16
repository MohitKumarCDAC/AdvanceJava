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
	public Apiresponse updatePatientRecord(Long id, Patient NewPatient) {
		String msg="Updation Failed....";
		if(patientRepo.existsById(id)) {
			patientRepo.save(NewPatient);
			msg="Updatation done.....";
		}else
		{
			throw new PatientNotFoundException("Invalid Patient ID:...");
		}
		return new Apiresponse(msg);
	}

}
