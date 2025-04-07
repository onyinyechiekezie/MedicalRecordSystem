package org.Medical.dto.response.patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterPatientResponse {

    private String message;
    private String patientId;
    private String email;
}
