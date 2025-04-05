package org.Medical.controllers;

import lombok.RequiredArgsConstructor;
import org.Medical.data.models.Patient;
import org.Medical.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private  PatientServices patientServices;

    @PostMapping("/register")
    public Patient register(@RequestBody Patient patient) {
        return patientServices.registerPatient(patient);
    }

    @PostMapping("/login")
    public Patient login(@RequestBody Patient patient) {
        return patientServices.loginPatient(patient.getEmail(), patient.getPassword());
    }



}
