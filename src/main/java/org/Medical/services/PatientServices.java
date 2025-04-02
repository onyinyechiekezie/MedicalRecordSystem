package org.Medical.services;

import org.Medical.data.models.Patient;
import org.Medical.data.repositories.AppointmentRepository;
import org.Medical.data.repositories.DoctorRepository;
import org.Medical.data.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServices {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient loginPatient(Patient patient) {}

    public Long countPatients() {
        return patientRepository.count();
    }

    public void deleteAll() {
        patientRepository.deleteAll();
    }

    public Patient getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }





}
