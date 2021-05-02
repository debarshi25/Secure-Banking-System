package edu.asu.cse545.group5.SBS.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.asu.cse545.group5.SBS.model.AppointmentKey;
import edu.asu.cse545.group5.SBS.model.AppointmentSlot;

public interface AppointmentSlotRepo extends JpaRepository<AppointmentSlot, AppointmentKey> {
    
}
