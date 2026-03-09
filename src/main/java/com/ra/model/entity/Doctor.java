package com.ra.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "doctor_code",length = 100,nullable = false,unique = true)
    private String doctorCode;
    @Column(name = "full_name", length = 100,nullable = false)
    private String fullName;
    @Column(name = "specialization",length = 150,nullable = false)
    private String specialization;
    @Column(name = "experience_years")
    private Integer experienceYears;


}
