package org.Medical.controllers;

import org.Medical.data.models.Appointment;
import org.Medical.services.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    @Autowired
    private AppointmentServices appointmentService;

    @PostMapping("/book")
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        return appointmentService.bookAppointment(appointment);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsForPatient(@PathVariable String patientId) {
        return appointmentService.getAppointmentsByPatient(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsForDoctor(@PathVariable String doctorId) {
        return appointmentService.getAppointmentsByDoctor(doctorId);
    }

    @DeleteMapping("/{appointmentId}")
    public void cancelAppointment(@PathVariable String appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
    }
}
