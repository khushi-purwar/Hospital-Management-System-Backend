package com.hms.profilems.repository;

import org.springframework.data.repository.CrudRepository;

import com.hms.profilems.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    
}
