package com.ra.service;

import com.ra.model.entity.MedicalRecord;
import com.ra.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    @Override
    public List<MedicalRecord> patientNewTop10() {
        return medicalRecordRepository.getTop10Patients();
    }
}
