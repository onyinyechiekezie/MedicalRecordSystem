package org.Medical.services;

import lombok.RequiredArgsConstructor;
import org.Medical.data.models.Appointment;
import org.Medical.data.repositories.AppointmentRepository;
import org.Medical.exceptions.AppointmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServices {

    private final AppointmentRepository appointmentRepository;

    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }


    public List<Appointment> getAppointmentsByPatient(String patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }


    public List<Appointment> getAppointmentsByDoctor(String doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }


    public void cancelAppointment(String appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() ->new AppointmentNotFoundException("Appointment not found"));
        appointmentRepository.delete(appointment);
    }

}
