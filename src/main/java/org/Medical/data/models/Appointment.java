package org.Medical.data.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class Appointment {
    @Id
    private String id;
    //private int appointmentId;
    @DBRef
    private Patient patient;
    private String appointmentDate;
    @DBRef
    private Doctor doctor;
    //private String patientAilment;





}


