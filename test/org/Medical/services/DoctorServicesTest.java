package org.Medical.services;


import org.Medical.data.models.Doctor;
import org.Medical.data.models.DoctorProfile;
import org.Medical.exceptions.DuplicateUserFoundException;
import org.Medical.exceptions.InvalidInputException;
import org.Medical.exceptions.UserNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DoctorServicesTest {

    @Autowired
    private DoctorServices doctorServices;

    private Doctor doctor;
    private DoctorProfile doctorProfile;

    @BeforeEach
    void setUp() {
        doctorProfile = new DoctorProfile();
        doctorProfile.setFirstName("Jane");
        doctorProfile.setLastName("Smith");
        doctorProfile.setSpecialization("Cardiology");

        doctor = new Doctor();
        doctor.setPassword("secure123");
        doctor.setProfile(doctorProfile);
    }

    @AfterEach
    void tearDown() {
        doctorServices.deleteAll();
    }

    @Test
    void registerDoctor_successful() {
        doctor.setEmail("doc1@test.com");
        Doctor newDoctor = doctorServices.registerDoctor(doctor);
        assertNotNull(newDoctor);
    }

    @Test
    void registerDoctor_countDoctors() {
        doctor.setEmail("doc2@test.com");
        Doctor doc2 = new Doctor();
        doc2.setEmail("doc3@test.com");
        doc2.setPassword("secure123");
        doc2.setProfile(doctorProfile);
        doctorServices.registerDoctor(doctor);
        doctorServices.registerDoctor(doc2);
        assertEquals(2, doctorServices.countDoctors());
    }

    @Test
    void registerDoctor_findByEmail() {
        doctor.setEmail("doc4@test.com");
        doctorServices.registerDoctor(doctor);
        Doctor found = doctorServices.getDoctorByEmail("doc4@test.com");
        assertNotNull(found);
        assertEquals("doc4@test.com", found.getEmail());
    }

    @Test
    void registerDoctor_duplicateEmail_throwsException() {
        doctor.setEmail("doc5@test.com");
        doctorServices.registerDoctor(doctor);

        Doctor duplicate = new Doctor();
        duplicate.setEmail("doc5@test.com");
        duplicate.setPassword("diffpass");

        assertThrows(DuplicateUserFoundException.class, () -> doctorServices.registerDoctor(duplicate));
    }

    @Test
    void registerDoctor_invalidEmail_throwsException() {
        doctor.setEmail("invalid email");
        assertThrows(InvalidInputException.class, () -> doctorServices.registerDoctor(doctor));
    }

    @Test
    void registerDoctor_missingEmail_throwsException() {
        doctor.setEmail(null);
        assertThrows(InvalidInputException.class, () -> doctorServices.registerDoctor(doctor));
    }

    @Test
    void registerDoctor_missingPassword_throwsException() {
        doctor.setEmail("doc6@test.com");
        doctor.setPassword(null);
        assertThrows(InvalidInputException.class, () -> doctorServices.registerDoctor(doctor));
    }

    @Test
    void loginDoctor_successfulLogin_returnsDoctor() {
        doctor.setEmail("doc7@test.com");
        doctorServices.registerDoctor(doctor);
        Doctor loggedIn = doctorServices.loginDoctor("doc7@test.com", "secure123");
        assertNotNull(loggedIn);
        assertEquals("doc7@test.com", loggedIn.getEmail());
    }

    @Test
    void loginDoctor_wrongPassword_throwsException() {
        doctor.setEmail("doc8@test.com");
        doctorServices.registerDoctor(doctor);

        assertThrows(InvalidInputException.class, () ->
                doctorServices.loginDoctor("doc8@test.com", "wrongPassword"));
    }

    @Test
    void loginDoctor_nonExistentEmail_throwsException() {
        assertThrows(UserNotFoundException.class, () ->
                doctorServices.loginDoctor("unknown@test.com", "pass"));
    }

    @Test
    void loginDoctor_emptyFields_throwsException() {
        assertThrows(UserNotFoundException.class, () ->
                doctorServices.loginDoctor("", ""));
    }

    @Test
    void loginDoctor_nullPassword_throwsException() {
        doctor.setEmail("doc9@test.com");
        doctorServices.registerDoctor(doctor);

        assertThrows(InvalidInputException.class, () ->
                doctorServices.loginDoctor("doc9@test.com", null));
    }
}
