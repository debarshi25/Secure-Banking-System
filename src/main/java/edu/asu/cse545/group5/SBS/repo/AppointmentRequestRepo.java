package edu.asu.cse545.group5.SBS.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.asu.cse545.group5.SBS.model.AppointmentRequest;

public interface AppointmentRequestRepo extends JpaRepository<AppointmentRequest, Long> {
    
    @Query(value = "SELECT * FROM appointment_requests ar WHERE ar.username = :username", nativeQuery = true)
    Optional<List<AppointmentRequest>> findAppointmentRequestByUsername(@Param("username") String username);
     
}
