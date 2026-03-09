package com.ra.controller;

import com.ra.model.entity.Doctor;
import com.ra.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<Doctor> doctors = doctorService.findAll();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Doctor doctor){

        Doctor doctorNew = doctorService.create(doctor);
        if (doctorNew != null){
            return new ResponseEntity<>(doctorNew, HttpStatus.CREATED);
        }
        return ResponseEntity.internalServerError().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Doctor doctor = doctorService.findById(id);
        if (doctor != null){
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Doctor doctor){
        Doctor doctorUpdate = doctorService.update(doctor, id);
        if (doctorUpdate != null){
            return new ResponseEntity<>(doctorUpdate, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id){
        doctorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

