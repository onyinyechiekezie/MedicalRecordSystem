package org.Medical.dto.response.doctor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDoctorResponse {

    private String message;
    private String patientId;
    private String email;
}
