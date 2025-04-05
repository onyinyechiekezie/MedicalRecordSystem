package org.Medical.Validators;

import org.Medical.data.models.Patient;

import org.Medical.exceptions.InvalidInputException;
import org.Medical.exceptions.UserNotFoundException;

import java.util.regex.Pattern;

public class PatientValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    public static void validateRegistration(Patient patient) {
        if (patient.getEmail() == null || !Pattern.matches(EMAIL_REGEX, patient.getEmail())) {
            throw new InvalidInputException("Invalid email");
        }
//        if (patient.getPassword() == null || !Pattern.matches(PASSWORD_REGEX, patient.getPassword())) {
//            throw new InvalidInputException("Invalid password");
//        }
        if (patient.getPassword() == null || patient.getPassword().trim().isEmpty()) {
            throw new InvalidInputException("Password is required");
        }
    }

    public static void validateLogin(String email, String inputPassword, Patient existingPatient) {
        if (email == null || !Pattern.matches(EMAIL_REGEX, email)) {
            throw new InvalidInputException("Invalid email.");
        }
        if (existingPatient == null) {
            throw new UserNotFoundException("Patient with email " + email + " not found.");
        }
        if (!existingPatient.getPassword().equals(inputPassword)) {
            throw new InvalidInputException("Invalid email or password. Please try again.");
        }
        if (email.trim().isEmpty())
            throw new InvalidInputException("Email cannot be empty");
        if (existingPatient.getPassword().trim().isEmpty()) {
            throw new InvalidInputException("Password is required");
        }
    }

    public static void validate(Patient patient) {
        if (patient == null) throw new InvalidInputException("Patient cannot be null");

        if (patient.getEmail() == null || !isValidEmail(patient.getEmail())) {
                throw new InvalidInputException("Invalid email");
        }

        if (patient.getPassword() == null || patient.getPassword().trim().isEmpty()) {
            throw new InvalidInputException("Password is required");
        }
        }

        private static boolean isValidEmail(String email) {
            return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        }


}