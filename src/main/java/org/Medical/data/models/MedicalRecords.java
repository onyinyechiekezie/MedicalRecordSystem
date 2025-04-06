package org.Medical.data.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecords {
    @Id
    private String id;
    @DBRef
    private Patient patient;
    private List<String> allergies;
    private List<String> chronicConditions;
    private List<String> surgeries;
    private String currentMedication;
    private List<String> immunizations;
    private String bloodType;
}





