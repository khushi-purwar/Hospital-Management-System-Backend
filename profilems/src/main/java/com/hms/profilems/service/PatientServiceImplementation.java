package com.hms.profilems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hms.profilems.dto.PatientDTO;
import com.hms.profilems.exception.HMSException;
import com.hms.profilems.repository.PatientRepository;

@Service
public class PatientServiceImplementation implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Long addPatient(PatientDTO patientDTO) throws HMSException {
        if(patientDTO.getEmail() !=null &&  patientRepository.findByEmail(patientDTO.getEmail()).isPresent()){
            throw new HMSException("PATIENT_ALREADY_EXISTS");
        }
        if(patientDTO.getAadharNumber() != null && patientRepository.findByAadharNumber(patientDTO.getAadharNumber()).isPresent()){
            throw new HMSException("PATIENT_ALREADY_EXISTS");
        }

        return patientRepository.save(patientDTO.toEntity()).getId();
    }

    @Override
    public PatientDTO getPatientById(Long id) throws HMSException {
       return patientRepository.findById(id).orElseThrow(() -> new HMSException("PATIENT_NOT_FOUND")).toDTO();
    }
}
