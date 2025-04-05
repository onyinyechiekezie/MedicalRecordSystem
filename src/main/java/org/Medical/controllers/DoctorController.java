package org.Medical.controllers;

import org.Medical.data.models.Doctor;
import org.Medical.services.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorServices doctorServices;

    @PostMapping("/register")
    public Doctor register(@RequestBody Doctor doctor) {
        return doctorServices.registerDoctor(doctor);
    }

//    @PostMapping("/login")
//    public Doctor login(@RequestBody Doctor doctor) {
//        return doctorServices.loginDoctor(doctor);
//    }

}