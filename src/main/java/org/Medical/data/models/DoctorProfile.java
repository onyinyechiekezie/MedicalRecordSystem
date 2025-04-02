package org.Medical.data.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Doctor Profile")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DoctorProfile {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String specialization;


}
