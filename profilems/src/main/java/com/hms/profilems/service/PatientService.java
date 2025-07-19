package com.hms.profilems.service;

import com.hms.profilems.dto.PatientDTO;
import com.hms.profilems.exception.HMSException;

public interface PatientService {
    public void addPatient(PatientDTO patientDTO) throws HMSException;
    public PatientDTO getPatientById(Long id) throws HMSException;
}
