package org.Medical.controllers;


import org.Medical.data.models.Patient;
import org.Medical.dto.request.patient.LoginPatientRequest;
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
    public ResponseEntity<String> login(@RequestBody LoginPatientRequest request) {
        try {
            patientServices.loginPatient(request.getEmail(), request.getPassword());
            return ResponseEntity.ok("Patient logged in successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
