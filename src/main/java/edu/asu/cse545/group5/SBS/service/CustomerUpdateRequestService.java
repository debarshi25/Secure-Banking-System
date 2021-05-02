package edu.asu.cse545.group5.SBS.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.cse545.group5.SBS.model.CustomerUpdateRequest;
import edu.asu.cse545.group5.SBS.repo.CustomerUpdateRequestRepo;

@Service
public class CustomerUpdateRequestService {

    private final CustomerUpdateRequestRepo customerUpdateRequestRepo;

    @Autowired
    public CustomerUpdateRequestService(CustomerUpdateRequestRepo customerUpdateRequestRepo) {
        this.customerUpdateRequestRepo = customerUpdateRequestRepo;
    }
    
    public CustomerUpdateRequest addCustomerUpdateRequest(CustomerUpdateRequest customerUpdateRequest) {
        customerUpdateRequest.setId(UUID.randomUUID().toString());
        return customerUpdateRequestRepo.save(customerUpdateRequest);
    }

    public CustomerUpdateRequest updateCustomerUpdateRequest(CustomerUpdateRequest customerUpdateRequest) {
        return customerUpdateRequestRepo.save(customerUpdateRequest);
    }
    
    public List<CustomerUpdateRequest> findAllCustomerUpdateRequestByEmployeeId(String employeeId) throws Exception {
        return customerUpdateRequestRepo.findCustomerUpdateRequestByEmployeeId(employeeId).orElseThrow(() -> new Exception("Employee not found"));
    }   

    public List<CustomerUpdateRequest> findAllCustomerUpdateRequestByUsername(String username) throws Exception {
        return customerUpdateRequestRepo.findCustomerUpdateRequestByUsername(username).orElseThrow(() -> new Exception("User not found"));
    }  
}
