package com.app.services;

import java.util.List;

import com.app.Dto.DoctorDto;

public interface DoctorService {
   DoctorDto addDoctor(DoctorDto doctor);
   List<DoctorDto> getAllDoctorList();
   DoctorDto getDoctorByID(Long id);
   String  deleteDoctorById(Long id);
   DoctorDto updateDoctor(Long id,DoctorDto doctorDto);
}
