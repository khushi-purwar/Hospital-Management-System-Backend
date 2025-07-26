package com.hms.profilems.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hms.profilems.dto.DoctorDTO;
import com.hms.profilems.exception.HMSException;
import com.hms.profilems.repository.DoctorRepository;

@Service
public class DoctorServiceImplementation implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Long addDoctor(DoctorDTO doctorDTO) throws HMSException {
        if(doctorDTO.getEmail() != null && doctorRepository.findByEmail(doctorDTO.getEmail()).isPresent()){
            throw new HMSException("DOCTOR_ALREADY_EXISTS");
        }

        if(doctorDTO.getLicenseNumber() != null && doctorRepository.findByLicenseNumber(doctorDTO.getLicenseNumber()).isPresent()){
            throw new HMSException("DOCTOR_ALREADY_EXISTS");
        }

        return doctorRepository.save(doctorDTO.toEntity()).getId();
    }

    @Override
    public DoctorDTO getDoctorById(Long id) throws HMSException {
        return doctorRepository.findById(id).orElseThrow(() -> new HMSException("DOCTOR_NOT_FOUND")).toDTO();
    }
    
}
