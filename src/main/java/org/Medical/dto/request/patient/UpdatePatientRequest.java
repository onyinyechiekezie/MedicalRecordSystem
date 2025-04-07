package org.Medical.dto.request.patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePatientRequest {

    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String phoneNumber;

}
