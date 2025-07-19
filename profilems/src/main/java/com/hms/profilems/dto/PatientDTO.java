package com.hms.profilems.dto;

import java.time.LocalDate;

import com.hms.profilems.entity.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private String phone;
    private String address;
    private String aadharNumber;
    private BloodGroup bloodGroup;
    
    public Patient toEntity() {
        return new Patient(this.id, this.name, this.email, this.dob, this.phone, this.address, this.aadharNumber, this.bloodGroup);
    }
}
