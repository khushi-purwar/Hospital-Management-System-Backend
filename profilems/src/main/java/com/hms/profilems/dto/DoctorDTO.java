package com.hms.profilems.dto;

import java.time.LocalDate;
import com.hms.profilems.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private String phone;
    private String address;
    private String licenseNumber;
    private String specialization;
    private String department;
    private Integer totalExp;

    public Doctor toEntity() {
        return new Doctor(
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
