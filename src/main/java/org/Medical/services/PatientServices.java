package org.Medical.services;

import org.Medical.data.models.Patient;
import org.Medical.data.repositories.AppointmentRepository;
import org.Medical.data.repositories.DoctorRepository;
import org.Medical.data.repositories.PatientRepository;
import org.Medical.Validators.PatientValidator;
import org.Medical.exceptions.DuplicateUserFoundException;
import org.Medical.exceptions.InvalidInputException;
import org.Medical.exceptions.UserNotFoundException;
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
        PatientValidator.validateRegistration(patient);
        if (patientRepository.findByEmail(patient.getEmail()) != null) {
            throw new DuplicateUserFoundException("A patient with email " + patient.getEmail() + " already exists.");
        }
        return patientRepository.save(patient);
    }

    public Patient loginPatient(String email, String password) {
        Patient patient = getPatientByEmail(email);  // will throw UserNotFoundException if not found
        PatientValidator.validateLogin(email, password, patient);
        return patient;


    }
//        PatientValidator.validateLogin(email, password);
//        if (email.trim().isEmpty())
//            throw new InvalidInputException("Email cannot be empty");
//        if (password == null || password.trim().isEmpty())
//            throw new InvalidInputException("Password cannot be empty");
//
//        Patient patient = getPatientByEmail(email);
//        if (!patient.getPassword().equals(password))
//            throw new InvalidInputException("Invalid email or password");
//
//        return patient;
//    }


    public Long countPatients () {
            return patientRepository.count();
        }

        public void deleteAll () {
            patientRepository.deleteAll();
        }

        public Patient getPatientByEmail (String email){
            Patient patient = patientRepository.findByEmail(email);
            if (patient == null) {
                throw new UserNotFoundException("No patient found with email: " + email);
            }
            return patient;
        }

        public List<Patient> getAllPatients () {
            return patientRepository.findAll();
        }



}

