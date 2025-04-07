package org.Medical.data.repositories;

import org.Medical.data.models.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface AppointmentRepository extends MongoRepository<Appointment, String> {
        List<Appointment> findByPatientId(String patientId);
        List<Appointment> findByDoctorId(String doctorId);

}
