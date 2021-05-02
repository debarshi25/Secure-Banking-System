package edu.asu.cse545.group5.SBS.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.cse545.group5.SBS.model.AppointmentRequest;
import edu.asu.cse545.group5.SBS.repo.AppointmentRequestRepo;

@Service
public class AppointmentRequestService {
    
    private final AppointmentRequestRepo appointmentRequestRepo;

    @Autowired
    public AppointmentRequestService(AppointmentRequestRepo appointmentRequestRepo) {
        this.appointmentRequestRepo = appointmentRequestRepo;
    }
    
    public AppointmentRequest addAppointmentRequest(AppointmentRequest appointmentRequest) {
        appointmentRequest.setId(UUID.randomUUID().toString());
        return appointmentRequestRepo.save(appointmentRequest);
    }

    public AppointmentRequest updateAppointmentRequest(AppointmentRequest appointmentRequest) {
        return appointmentRequestRepo.save(appointmentRequest);
    }
    
    public List<AppointmentRequest> findAllAppointmentRequest() {
        return appointmentRequestRepo.findAll();
    }

    public List<AppointmentRequest> findAppointmentRequestByUsername(String username) throws Exception {
        return appointmentRequestRepo.findAppointmentRequestByUsername(username).orElseThrow(() -> new Exception("User not found"));
    }

}
