package org.Medical.controllers;

import org.Medical.data.models.Patient;
import org.Medical.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientServices patientServices;

    @PostMapping("/register")
    public Patient register(@RequestBody Patient patient) {
        return patientServices.registerPatient(patient);
    }
    @GetMapping("/{id}")
    public List<Patients> getAllPatients() {return patienServices.getPatientById(id);}

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable String id, @RequestBody Patient patient) {
        return patientServices.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable String id) {
        patientServices.deletePatient(id);
    }
}

