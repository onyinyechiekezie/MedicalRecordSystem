package org.Medical.services;

import org.Medical.Validators.PatientValidator;
import org.Medical.data.models.Doctor;
import org.Medical.data.models.Patient;
import org.Medical.data.repositories.AppointmentRepository;
import org.Medical.data.repositories.DoctorRepository;
import org.Medical.data.repositories.PatientRepository;
import org.Medical.exceptions.DuplicateUserFoundException;
import org.Medical.Validators.DoctorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServices {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Doctor registerDoctor(Doctor doctor) {
        DoctorValidator.validateRegistration(doctor);
        if (doctorRepository.findByEmail(doctor.getEmail()) != null) {
            throw new DuplicateUserFoundException("A doctor with email " + doctor.getEmail() + " already exists.");
        }
        return doctorRepository.save(doctor);
    }

//    public Doctor loginDoctor (String email, String password) {
//        Doctor existingDoctor = doctorRepository.findByEmail(email);
//        DoctorValidator.validateLogin(email, password, existingDoctor);
//        return existingDoctor;
//    }

}

