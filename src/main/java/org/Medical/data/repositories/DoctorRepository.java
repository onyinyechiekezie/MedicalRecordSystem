package org.Medical.data.repositories;


import org.Medical.data.models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
    Doctor findByEmail(String email);
}
