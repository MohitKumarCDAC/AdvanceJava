package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.print.Doc;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.DoctorDto;
import com.app.Exception.DoctorNotFoundException;
import com.app.entity.Doctor;
import com.app.repository.DoctorRepository;
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
			
	@Autowired
	private DoctorRepository doctorrepository;
	
	@Autowired
	private ModelMapper modelMapper;
		
	
	@Override
	public DoctorDto addDoctor(DoctorDto doctordto) {
		//chane data doctor into doctordto
		System.out.println("in doctor:"+doctordto);
	  Doctor doctor=modelMapper.map(doctordto, Doctor.class);
	  System.out.println("in doctor:"+doctor);
	  Doctor d=doctorrepository.save(doctor);
	  return modelMapper.map(d, DoctorDto.class);
	}


	@Override
	public List<DoctorDto> getAllDoctorList() {
		
		return doctorrepository.findAll().stream()
				.map(doctor->modelMapper.map(doctor, DoctorDto.class))
				.collect(Collectors.toList());
						
	}


	@Override
	public DoctorDto getDoctorByID(Long id) {
		
		Doctor doctor= doctorrepository.findById(id)
				.orElseThrow(()->new DoctorNotFoundException("Doctor Id mismatch"));
		return modelMapper.map(doctor, DoctorDto.class);
	}


	@Override
	public DoctorDto deleteDoctorById(Long id) {
		Doctor doctor=doctorrepository.findById(id)
				.orElseThrow(()->new DoctorNotFoundException("Doctor id Mismatch...."));
		doctorrepository.deleteById(id);
		
		return modelMapper.map(doctor, DoctorDto.class);
	}

}
