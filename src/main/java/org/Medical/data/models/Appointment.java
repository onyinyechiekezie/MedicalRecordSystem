package org.Medical.data.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class Appointment {
    @Id
    private String id;
    @DBRef
    private Patient patient;
    private LocalDateTime appointmentDime;
    @DBRef
    private Doctor doctor;
    private String reason;
    private String status;
    private String comment;






}


