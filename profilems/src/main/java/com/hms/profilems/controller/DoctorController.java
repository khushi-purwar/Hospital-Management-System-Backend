package com.hms.profilems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hms.profilems.dto.DoctorDTO;
import com.hms.profilems.dto.PatientDTO;
import com.hms.profilems.exception.HMSException;
import com.hms.profilems.service.DoctorService;

@RestController
@CrossOrigin
@RequestMapping("/profile/doctor")
@Validated
public class DoctorController {
    
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<Long> addDoctor(@RequestBody DoctorDTO doctorDTO) throws HMSException {
        return new ResponseEntity<>(doctorService.addDoctor(doctorDTO), HttpStatus.CREATED);
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<DoctorDTO> getDoctor(@PathVariable Long id) throws HMSException{
        return new ResponseEntity<>(doctorService.getDoctorById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<DoctorDTO> updatePatient(@RequestBody DoctorDTO doctorDTO) throws HMSException {
        return new ResponseEntity<>(doctorService.updateDoctor(doctorDTO), HttpStatus.OK);
    }
}
