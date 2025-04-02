package org.Medical.data.repositories;

import org.Medical.data.models.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface AppointmentRepository extends MongoRepository<Appointment, String> {


}
