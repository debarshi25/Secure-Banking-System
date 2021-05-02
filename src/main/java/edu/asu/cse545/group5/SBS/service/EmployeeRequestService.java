package edu.asu.cse545.group5.SBS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.cse545.group5.SBS.repo.EmployeeRequestRepo;

@Service
public class EmployeeRequestService {

    private final EmployeeRequestRepo employeeRequestRepo;

    @Autowired
    public EmployeeRequestService(EmployeeRequestRepo employeeRequestRepo) {
        this.employeeRequestRepo = employeeRequestRepo;
    }
}
