package org.Medical.controllers;

import org.Medical.data.models.Doctor;
import org.Medical.data.models.Patient;
import org.Medical.dto.request.doctor.RegisterDoctorRequest;
import org.Medical.services.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.Medical.utility.DoctorMapper.mapToDoctor;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorServices doctorServices;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDoctorRequest request) {
            try {
                Doctor doctor = mapToDoctor(request);
                doctorServices.registerDoctor(doctor);
                return ResponseEntity.ok().body("Doctor registered successfully");
            } catch (Exception exception){
                return ResponseEntity.badRequest().body(exception.getMessage());
            }
    }

//    @PostMapping("/login")
//    public Doctor login(@RequestBody Doctor doctor) {
//        return doctorServices.loginDoctor(doctor);
//    }

}