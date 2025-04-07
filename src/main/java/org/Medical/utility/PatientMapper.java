package org.Medical.utility;

import org.Medical.data.models.Patient;
import org.Medical.data.models.PatientProfile;
import org.Medical.dto.request.patient.RegisterPatientRequest;

public class PatientMapper {
    public static Patient mapToPatient(RegisterPatientRequest request) {
        PatientProfile profile = new PatientProfile();
        profile.setGender(request.getGender());
        profile.setFirstName(request.getFirstName());
        profile.setLastName(request.getLastName());
        profile.setDateOfBirth(request.getDateOfBirth());


        Patient patient = new Patient();
        patient.setEmail(request.getEmail());
        patient.setPassword(request.getPassword());
        patient.setProfile(profile);

        return patient;
    }
}
