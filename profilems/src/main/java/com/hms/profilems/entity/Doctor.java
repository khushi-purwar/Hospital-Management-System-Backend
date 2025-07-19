package com.hms.profilems.entity;

import java.time.LocalDate;
import com.hms.profilems.dto.DoctorDTO;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private LocalDate dob;
    private String phone;
    private String address;
    @Column(unique=true)
    private String licenseNumber;
    private String specialization;
    private String department; 
    private Integer totalExp; // in years

    public DoctorDTO toDTO() {
        return new DoctorDTO(
            this.id,
            this.name,
            this.email,
            this.dob,
            this.phone,
            this.address,
            this.licenseNumber,
            this.specialization,
            this.department,
            this.totalExp
        );
    }
}
