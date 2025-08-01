package com.hms.profilems.service;

import com.hms.profilems.dto.DoctorDTO;
import com.hms.profilems.exception.HMSException;

public interface DoctorService {
    public Long addDoctor(DoctorDTO doctorDTO) throws HMSException;
    public DoctorDTO getDoctorById(Long id) throws HMSException;
    public DoctorDTO updateDoctor(DoctorDTO doctorDTO) throws HMSException;
}
