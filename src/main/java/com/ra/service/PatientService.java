package com.ra.service;

import com.ra.model.dto.PaginationResponse;
import com.ra.model.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    PaginationResponse<Patient> findAll(Pageable pageable, String keywordPatientName);
}
