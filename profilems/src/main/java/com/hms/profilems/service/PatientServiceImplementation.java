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
    public void addPatient(PatientDTO patientDTO) throws HMSException {
        if(patientRepository.existsById(patientDTO.getId())){
            throw new HMSException("PATIENT_ALREADY_EXISTS");
        }

        patientRepository.save(patientDTO.toEntity());
    }

    @Override
    public PatientDTO getPatientById(Long id) throws HMSException {
       return patientRepository.findById(id).orElseThrow(() -> new HMSException("PATIENT_NOT_FOUND")).toDTO();
    }
}
