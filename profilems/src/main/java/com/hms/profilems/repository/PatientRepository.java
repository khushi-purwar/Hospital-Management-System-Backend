package com.hms.profilems.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hms.profilems.entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    Optional<Patient>findByEmail(String email);
    Optional<Patient>findByAadharNumber(String aadharNumber);
}
