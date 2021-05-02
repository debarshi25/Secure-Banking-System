package edu.asu.cse545.group5.SBS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.cse545.group5.SBS.repo.AppointmentSlotRepo;

@Service
public class AppointmentSlotService {

    private final AppointmentSlotRepo appointmentSlotRepo;

    @Autowired
    public AppointmentSlotService(AppointmentSlotRepo appointmentSlotRepo) {
        this.appointmentSlotRepo = appointmentSlotRepo;
    }
}
