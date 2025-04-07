package org.Medical.services;


import org.Medical.data.models.Doctor;
import org.Medical.data.repositories.AppointmentRepository;
import org.Medical.data.repositories.DoctorRepository;
import org.Medical.data.repositories.DoctorProfileRepository;
import org.Medical.data.repositories.PatientRepository;
import org.Medical.exceptions.DuplicateUserFoundException;
import org.Medical.Validators.DoctorValidator;
import org.Medical.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServices {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorProfileRepository doctorProfileRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Doctor registerDoctor(Doctor doctor) {
        DoctorValidator.validateRegistration(doctor);
        if (doctorRepository.findByEmail(doctor.getEmail()) != null) {
            throw new DuplicateUserFoundException("A doctor with email " + doctor.getEmail() + " already exists.");
        }
        doctorProfileRepository.save(doctor.getProfile());
        return doctorRepository.save(doctor);
    }

    public Doctor loginDoctor(String email, String password) {
        Doctor doctor = getDoctorByEmail(email);
        DoctorValidator.validateLogin(email, password, doctor);
        return doctor;

    }

    Doctor getDoctorByEmail(String email) {
        Doctor doctor = doctorRepository.findByEmail(email);
        if (doctor == null) {
            throw new UserNotFoundException("No doctor found with email: " + email);
        }
        return doctor;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(String id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor updateDoctor(String id, Doctor doctor) {
        doctor.setId(id);
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(String id) {
        doctorRepository.deleteById(id);
    }

    public Doctor findByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }

    public void deleteAll() {
        doctorRepository.deleteAll();
    }

    public long countDoctors() {
        return doctorRepository.count();
    }
}

