package com.ra.service;

import com.ra.model.dto.PaginationResponse;
import com.ra.model.entity.Patient;
import com.ra.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public PaginationResponse<Patient> findAll(Pageable pageable,String keywordPatientName) {
        Page<Patient> page = patientRepository.findByFullNameContainingIgnoreCase(keywordPatientName,pageable);

        // Convert Page -> DTO
        return PaginationResponse.<Patient>builder()
                .data(page.getContent())
                .totalPage(page.getTotalPages())
                .totalElement((int) page.getTotalElements())
                .currentPage(page.getNumber())
                .build();
    }
}
