package org.Medical.services;

import org.Medical.data.models.Patient;
import org.Medical.data.models.PatientProfile;
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
class PatientServicesTest {

    @Autowired
    private PatientServices patientServices;
    private Patient patient;
    private  PatientProfile patientProfile;

    @BeforeEach
    void setUp() {
        patientProfile = new PatientProfile();
        patientProfile.setFirstName("John");
        patientProfile.setLastName("Doe");
        patientProfile.setDateOfBirth("34-89-25");
        patientProfile.setGender("Male");

        patient = new Patient();
        patient.setPassword("test");
        patient.setProfile(patientProfile);
    }

    @AfterEach
    void tearDown() {
        patientServices.deleteAll();
    }

    @Test
    void registerPatient() {
        patient.setEmail("test@test.com");
        Patient newPatient = patientServices.registerPatient(patient);
        assertNotNull(newPatient);
    }

    @Test
    void registerPatient_countPatients() {
        patient.setEmail("test1@test.com");
        Patient patient2 = new Patient();
        patient2.setEmail("test2@test.com");
        patient2.setPassword("test");
        patient2.setProfile(patientProfile);
        Patient newPatient = patientServices.registerPatient(patient);
        patientServices.registerPatient(patient2);
        assertNotNull(newPatient);

        assertEquals(2, patientServices.countPatients());
    }

    @Test
    void registerPatient_findPatientByEmail() {
        patient.setEmail("test3@test.com");
        Patient newPatient = patientServices.registerPatient(patient);
        assertNotNull(newPatient);
        patientServices.getPatientByEmail("test3@test.com");
        assertEquals(newPatient, patientServices.getPatientByEmail("test3@test.com"));
    }

    @Test
    void registerPatient_duplicateEmail_throwsException() {
        patient.setEmail("test4@test.com");
        patientServices.registerPatient(patient);
        Patient duplicate = new Patient();
        duplicate.setEmail("test4@test.com");
        duplicate.setPassword("another pass");
        assertThrows(DuplicateUserFoundException.class, () -> patientServices.registerPatient(duplicate));
    }

    @Test
    void registerPatient_invalidEmail_throwsException() {
        patient.setEmail("invalid email");
        assertThrows(InvalidInputException.class, () -> patientServices.registerPatient(patient));
    }

    @Test
    void registerPatient_missingEmail_throwsException() {
        patient.setEmail(null);
        assertThrows(InvalidInputException.class, () -> patientServices.registerPatient(patient));
    }

    @Test
    void registerPatient_missingPassword_throwsException() {
        patient.setEmail("test5@test.com");
        patient.setPassword(null);
        assertThrows(InvalidInputException.class, () -> patientServices.registerPatient(patient));
    }

    @Test
    void registerPatient_emptyEmailAndPasswordFields_throwsException() {
        patient.setEmail("");
        patient.setPassword("");
        assertThrows(InvalidInputException.class, () -> patientServices.registerPatient(patient));
    }

    @Test
    void loginPatient_successfulLogin_returnsPatient() {
        patient.setEmail("onyii@test.com");
        patientServices.registerPatient(patient);
        Patient loggedIn = patientServices.loginPatient("onyii@test.com", "test");
        assertNotNull(loggedIn);
        assertEquals("onyii@test.com", loggedIn.getEmail());
    }

    @Test
    void loginPatient_wrongPassword_throwsException() {
        patient.setEmail("Tot@test.com");
        patientServices.registerPatient(patient);
        assertThrows(InvalidInputException.class, () -> patientServices.loginPatient("Tot@test.com", "wrongPassword"));
    }

    @Test
    void loginPatient_nonexistentEmail_throwsException() {
        assertThrows(UserNotFoundException.class, () ->
                patientServices.loginPatient("nonexistent@test.com", "Element123"));
    }

    @Test
    void loginPatient_emptyEmailFields_throwsExceptionTest() {
        assertThrows(UserNotFoundException.class, () ->
                patientServices.loginPatient("", ""));
    }

    @Test
    void loginPatient_emptyPassword_throwsExceptionTest() {
        patient.setEmail("jane@example.com");
        patientServices.registerPatient(patient);

        assertThrows(InvalidInputException.class, () ->
                patientServices.loginPatient("jane@example.com", null));
    }






}