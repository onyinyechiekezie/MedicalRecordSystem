package org.Medical.dto.request.patient;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterPatientRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
}
