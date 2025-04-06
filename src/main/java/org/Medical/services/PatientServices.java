package org.Medical.services;

import lombok.RequiredArgsConstructor;
import org.Medical.data.models.Appointment;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class PatientServices {


    private final PatientRepository patientRepository;

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



//        public List<Appointment> viewAppointments(String patientId) {
//            return appointmentService.getAppointmentsByPatient(patientId);
//        }
//
//        public void cancelAppointment(String appointmentId) {
//            appointmentService.cancelAppointment(appointmentId);
//    }



}

