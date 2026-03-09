package com.ra.controller;

import com.ra.model.dto.PaginationResponse;
import com.ra.model.entity.Patient;
import com.ra.repository.PatientRepository;
import com.ra.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping("")
    public ResponseEntity<?> findAll(@PageableDefault(
            size = 10,sort = "fullName",direction = Sort.Direction.DESC
    ) Pageable pageable,@RequestParam(required = false,defaultValue = "",name = "keyword") String keywordPatientName

    ) {
        PaginationResponse<Patient> patients = patientService.findAll
                (pageable,keywordPatientName);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}
