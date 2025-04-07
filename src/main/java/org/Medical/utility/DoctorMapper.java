package org.Medical.utility;

import org.Medical.data.models.Doctor;
import org.Medical.data.models.DoctorProfile;
import org.Medical.dto.request.doctor.RegisterDoctorRequest;

public class DoctorMapper {

    public static Doctor mapToDoctor(RegisterDoctorRequest request) {
        DoctorProfile profile = new DoctorProfile();
        profile.setFirstName(request.getFirstName());
        profile.setLastName(request.getLastName());
        profile.setGender(request.getGender());
        profile.setSpecialization(request.getSpecialization());

        Doctor doctor = new Doctor();
        doctor.setEmail(request.getEmail());
        doctor.setPassword(request.getPassword());
        doctor.setProfile(profile);

        return doctor;
    }
}
