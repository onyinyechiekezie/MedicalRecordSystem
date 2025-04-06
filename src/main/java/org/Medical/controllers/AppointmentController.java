package org.Medical.controllers;

import org.Medical.data.models.Appointment;
import org.Medical.services.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentServices appointmentServices;

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentServices.createAppointment(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentServices.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable String id) {
        return appointmentServices.getAppointmentById(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatient(@PathVariable String patientId) {
        return appointmentServices.getAppointmentsByPatient(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctor(@PathVariable String doctorId) {
        return appointmentServices.getAppointmentsByDoctor(doctorId);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable String id, @RequestBody Appointment appointment) {
        return appointmentServices.updateAppointment(id, appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable String id) {
        appointmentServices.deleteAppointment(id);
    }
}

