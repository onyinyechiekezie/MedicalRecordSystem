package org.Medical.data.repositories;

import org.Medical.data.models.DoctorProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorProfileRepository extends MongoRepository<DoctorProfile, String> {

}
