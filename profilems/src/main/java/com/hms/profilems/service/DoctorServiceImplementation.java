package com.hms.profilems.service;

import org.springframework.stereotype.Service;

import com.hms.profilems.dto.DoctorDTO;
import com.hms.profilems.exception.HMSException;

@Service
public class DoctorServiceImplementation implements DoctorService{

    @Override
    public void addDoctor(DoctorDTO doctorDTO) throws HMSException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addDoctor'");
    }

    @Override
    public DoctorDTO getDoctorById(Long id) throws HMSException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDoctorById'");
    }
    
}
