package org.Medical.services;

import org.Medical.data.models.Patient;
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




}