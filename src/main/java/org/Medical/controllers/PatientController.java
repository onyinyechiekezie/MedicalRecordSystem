package org.Medical.controllers;

import org.Medical.data.models.Patient;
import org.Medical.dto.request.patient.RegisterPatientRequest;
import org.Medical.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.Medical.utility.PatientMapper.mapToPatient;

@RestController
@RequestMapping("/patients/")
public class PatientController {

    @Autowired
    private  PatientServices patientServices;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterPatientRequest request) {
       try {
           Patient patient = mapToPatient(request);
           patientServices.registerPatient(patient);
           return ResponseEntity.ok().body("Patient registered successfully");
       } catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
       }
    }

    @PostMapping("login")
    public Patient login(@RequestBody Patient patient) {
        return patientServices.loginPatient(patient.getEmail(), patient.getPassword());
    }



}
