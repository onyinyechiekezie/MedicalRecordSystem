package org.Medical.services;

import org.Medical.data.models.Appointment;
import org.Medical.data.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServices {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) { return appointmentRepository.save(appointment); }

    public List<Appointment> getAllAppointments() { return appointmentRepository.findAll(); }

    public Appointment getAppointmentById(String id) { return appointmentRepository.findById(id).orElse(null); }

    public List<Appointment> getAppointmentsByDoctor(String doctorId){ return appointmentRepository.findByDoctorId(doctorId); }

    public List<Appointment> getAppointmentsByPatient(String patientId){ return appointmentRepository.findPatientById(patientId); }
    public void deleteAppointment(String id) { appointmentRepository.deleteById(id); }
}