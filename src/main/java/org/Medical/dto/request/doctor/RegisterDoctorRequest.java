package org.Medical.dto.request.doctor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDoctorRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String specialization;
    private String gender;


}
