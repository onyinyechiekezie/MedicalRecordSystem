package org.Medical.dto.request.patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginPatientRequest {

    private String email;
    private String password;
}
