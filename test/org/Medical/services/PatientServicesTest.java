package org.Medical.services;

import org.Medical.data.models.Patient;
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

    @BeforeEach
    void setUp() {
        patientServices.deleteAll();
    }

    @AfterEach
    void tearDown() {
        patientServices.deleteAll();
    }

    @Test
    void registerPatient() {
        Patient patient = new Patient();
        patient.setEmail("test@test.com");
        patient.setPassword("test");
        Patient newPatient = patientServices.registerPatient(patient);
        assertNotNull(newPatient);
    }

    @Test
    void registerPatient_countPatients() {
        Patient patient = new Patient();
        patient.setEmail("test@test.com");
        patient.setPassword("test");
        Patient patient2 = new Patient();
        patient2.setEmail("test2@test.com");
        patient2.setPassword("test");
        Patient newPatient = patientServices.registerPatient(patient);
        Patient newPatient2 = patientServices.registerPatient(patient2);
        assertNotNull(newPatient);
        assertEquals(2, patientServices.countPatients());
    }

    @Test
    void registerPatient_findPatientByEmail() {
        Patient patient = new Patient();
        patient.setEmail("test@test.com");
        patient.setPassword("test");
        Patient newPatient = patientServices.registerPatient(patient);
        assertNotNull(newPatient);
        patientServices.getPatientByEmail("test@test.com");
        assertEquals(newPatient, patientServices.getPatientByEmail("test@test.com"));
    }

    @Test
    void registerPatient_duplicateEmail_throwsException() {
        Patient patient = new Patient();
        patient.setEmail("test@test.com");
        patient.setPassword("test");
        patientServices.registerPatient(patient);
        Patient duplicate = new Patient();
        duplicate.setEmail("test@test.com");
        duplicate.setPassword("anotherpass");
        assertThrows(DuplicateUserFoundException.class, () -> patientServices.registerPatient(duplicate));
    }

    @Test
    void registerPatient_invalidEmail_throwsException() {
        Patient patient = new Patient();
        patient.setEmail("invalid-email");
        patient.setPassword("test");
        assertThrows(InvalidInputException.class, () -> patientServices.registerPatient(patient));
    }

    @Test
    void registerPatient_missingEmail_throwsException() {
        Patient patient = new Patient();
        patient.setEmail(null);
        patient.setPassword("test");
        assertThrows(InvalidInputException.class, () -> patientServices.registerPatient(patient));
    }

    @Test
    void registerPatient_missingPassword_throwsException() {
        Patient patient = new Patient();
        patient.setEmail("test@test.com");
        patient.setPassword(null);
        assertThrows(InvalidInputException.class, () -> patientServices.registerPatient(patient));
    }

    @Test
    void registerPatient_emptyEmailAndPasswordFields_throwsException() {
        Patient patient = new Patient();
        patient.setEmail("");
        patient.setPassword("");
        assertThrows(InvalidInputException.class, () -> patientServices.registerPatient(patient));
    }

    @Test
    void loginPatient_successfulLogin_returnsPatient() {
        Patient patient = new Patient();
        patient.setEmail("onyii@test.com");
        patient.setPassword("Element123");
        patientServices.registerPatient(patient);
        Patient loggedIn = patientServices.loginPatient("onyii@test.com", "Element123");
        assertNotNull(loggedIn);
        assertEquals("onyii@test.com", loggedIn.getEmail());
    }

    @Test
    void loginPatient_wrongPassword_throwsException() {
        Patient patient = new Patient();
        patient.setEmail("Tot@test.com");
        patient.setPassword("Element123");
        patientServices.registerPatient(patient);
        assertThrows(InvalidInputException.class, () -> patientServices.loginPatient("Tot@test.com", "wrongPassword"));
    }

    @Test
    void loginPatient_nonexistentEmail_throwsException() {
        assertThrows(UserNotFoundException.class, () ->
                patientServices.loginPatient("nonexistent@test.com", "Element123"));
    }

    @Test
    void loginPatient_emptyEmailField_throwsExceptionTest() {
        assertThrows(InvalidInputException.class, () ->
                patientServices.loginPatient(null, ""));
    }

    @Test
    void loginPatient_emptyPassword_throwsExceptionTest() {
        Patient patient = new Patient();
        patient.setEmail("jane@example.com");
        patient.setPassword("pass123");
        patientServices.registerPatient(patient);

        assertThrows(InvalidInputException.class, () ->
                patientServices.loginPatient("jane@example.com", null));
    }






}