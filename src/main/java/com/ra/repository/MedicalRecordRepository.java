package com.ra.repository;

import com.ra.model.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {

//    @Query("SELECT m FROM MedicalRecord m WHERE m.status = 'PROCESSING' ORDER BY m.createdAt DESC")
    @NativeQuery("SELECT * FROM medical_records WHERE status = 'PROCESSING' ORDER BY created_at DESC ")
    List<MedicalRecord> getTop10Patients();
}
