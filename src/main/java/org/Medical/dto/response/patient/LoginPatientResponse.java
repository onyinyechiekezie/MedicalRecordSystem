package org.Medical.dto.response.patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginPatientResponse {

    private String message;
    private String patientId;
    private String fullName;
    private String email;
}
