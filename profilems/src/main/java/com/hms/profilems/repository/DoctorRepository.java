package com.hms.profilems.repository;

import org.springframework.data.repository.CrudRepository;

import com.hms.profilems.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long>{
    
}
