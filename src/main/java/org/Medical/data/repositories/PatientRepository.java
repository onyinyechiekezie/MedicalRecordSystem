package org.Medical.data.repositories;

import org.Medical.data.models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

    Patient findByEmail(String email);


}
