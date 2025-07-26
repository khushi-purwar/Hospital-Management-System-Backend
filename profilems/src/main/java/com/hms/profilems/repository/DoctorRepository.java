package com.hms.profilems.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hms.profilems.entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long>{
    Optional<Doctor>findByEmail(String email);
    Optional<Doctor>findByLicenseNumber(String licenseNumber);
}
