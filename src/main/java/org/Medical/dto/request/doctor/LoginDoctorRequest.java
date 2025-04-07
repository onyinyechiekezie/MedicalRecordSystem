package org.Medical.dto.request.doctor;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDoctorRequest {

    private String email;
    private String password;
}
