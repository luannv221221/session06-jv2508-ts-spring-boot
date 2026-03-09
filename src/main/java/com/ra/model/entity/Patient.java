package com.ra.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "patient_code", unique = true,nullable = false)
    private String patientCode;
    @Column(name = "full_name",nullable = false,length = 100)
    private String fullName;
    @Column(name = "phone",nullable = false,length = 13,unique = true)
    private String phone;
    @Column(name = "address")
    private String address;

}
