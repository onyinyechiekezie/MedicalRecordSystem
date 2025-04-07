package org.Medical.data.repositories;

import org.Medical.data.models.PatientProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientProfileRepository extends MongoRepository<PatientProfile, String> {


}
