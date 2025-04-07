package org.Medical.Validators;

import org.Medical.data.models.Doctor;
import org.Medical.data.models.Patient;
import org.Medical.exceptions.InvalidInputException;
import org.Medical.exceptions.UserNotFoundException;

import java.util.regex.Pattern;

public class DoctorValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    public static void validateRegistration(Doctor doctor) {
        if (doctor.getEmail() == null || !Pattern.matches(EMAIL_REGEX, doctor.getEmail())) {
            throw new InvalidInputException("Invalid email");
        }
        if (doctor.getPassword() == null || doctor.getPassword().trim().isEmpty()) {
            throw new InvalidInputException("Password is required");
        }
    }

    public static void validateLogin(String email, String inputPassword, Doctor existingDoctor) {
        if (email == null || !Pattern.matches(EMAIL_REGEX, email)) {
            throw new InvalidInputException("Invalid email.");
        }
        if (existingDoctor == null) {
            throw new UserNotFoundException("Doctor with email " + email + " not found.");
        }
        if (!existingDoctor.getPassword().equals(inputPassword)) {
            throw new InvalidInputException("Invalid email or password. Please try again.");
        }
        if (email.trim().isEmpty())
            throw new InvalidInputException("Email cannot be empty");
        if (existingDoctor.getPassword().trim().isEmpty()) {
            throw new InvalidInputException("Password is required");
        }


    }
}
