package edu.asu.cse545.group5.SBS.resource;

import edu.asu.cse545.group5.SBS.model.AppointmentRequest;
import edu.asu.cse545.group5.SBS.service.AppointmentRequestService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointmentRequest")
public class AppointmentRequestResource {

    private final AppointmentRequestService appointmentRequestService;
    public AppointmentRequestResource(AppointmentRequestService appointmentRequestService) {
        this.appointmentRequestService = appointmentRequestService;
    }
    
    @PostMapping("/addAppointmentRequest")
    public ResponseEntity<AppointmentRequest> createAccount(@RequestBody AppointmentRequest appointmentRequest) {
        AppointmentRequest newAppointmentRequest = appointmentRequestService.addAppointmentRequest(appointmentRequest);
        return new ResponseEntity<>(newAppointmentRequest, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AppointmentRequest>> getAllEmployee() {
        List<AppointmentRequest> appointmentRequest = appointmentRequestService.findAllAppointmentRequest();
        return new ResponseEntity<>(appointmentRequest, HttpStatus.OK);
    }

    @GetMapping("/getAppointmentRequest/{username}")
    public ResponseEntity<List<AppointmentRequest>> getAppointmentRequestById (@PathVariable("username") String username) throws Exception {
        List<AppointmentRequest> appointmentRequest = appointmentRequestService.findAppointmentRequestByUsername(username);
        return new ResponseEntity<>(appointmentRequest, HttpStatus.OK);
    }

    @PutMapping("/updateAppointmentRequest") 
    public ResponseEntity<AppointmentRequest> updateAppointmentRequest(@RequestBody AppointmentRequest appointmentRequest) {
        AppointmentRequest updateAppointmentRequest = appointmentRequestService.updateAppointmentRequest(appointmentRequest);
        return new ResponseEntity<>(updateAppointmentRequest, HttpStatus.OK);
    }
}