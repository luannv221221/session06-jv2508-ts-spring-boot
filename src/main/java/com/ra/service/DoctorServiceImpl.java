package com.ra.service;

import com.ra.model.entity.Doctor;
import com.ra.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Long id) {

        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Doctor doctor, Long id) {
        if (doctorRepository.findById(id).isPresent()) {
            doctor.setId(id);
            return doctorRepository.save(doctor);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
