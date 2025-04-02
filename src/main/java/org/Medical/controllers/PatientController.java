package org.Medical.controllers;

import org.Medical.data.models.Patient;
import org.Medical.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    private PatientServices patientServices;

    @PostMapping("/register")
    public Patient register(@RequestBody Patient patient) {
        return patientServices.registerPatient(patient);
    }




}
