package org.Medical.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Patient Profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientProfile {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private String HEIGHT;
    private String WEIGHT;



}
