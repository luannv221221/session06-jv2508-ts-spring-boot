package com.ra.controller;

import com.ra.model.entity.MedicalRecord;
import com.ra.repository.MedicalRecordRepository;
import com.ra.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;
    @GetMapping("/stats/latest-patients")
    public ResponseEntity<?> getLatestPatients() {
        return new ResponseEntity<>(medicalRecordService.patientNewTop10(), HttpStatus.OK);
    }
}
