package com.app.services;

import java.util.List;

import com.app.Dto.Apiresponse;
import com.app.Dto.PatientDto;
import com.app.entity.Patient;

public interface PatientService {
    PatientDto insertData(PatientDto patient);
    List<PatientDto> getAllPatients();
    PatientDto getByID(Long id);
    PatientDto deleteByID(Long id);
    PatientDto updatePatientRecord(Long id,PatientDto NewPatient);
}
