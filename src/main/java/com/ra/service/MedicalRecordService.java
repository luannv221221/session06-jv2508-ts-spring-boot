package com.ra.service;

import com.ra.model.entity.MedicalRecord;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface MedicalRecordService {
    List<MedicalRecord> patientNewTop10 ();
}
