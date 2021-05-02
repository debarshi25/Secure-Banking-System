package edu.asu.cse545.group5.SBS.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.asu.cse545.group5.SBS.model.CustomerUpdateRequest;

public interface CustomerUpdateRequestRepo extends JpaRepository<CustomerUpdateRequest, Long> {

    //Get the list of all request for a customer (raised by employee)
    @Query(value = "SELECT * FROM appointment_requests ar WHERE ar.username = :username", nativeQuery = true)
    Optional<List<CustomerUpdateRequest>> findCustomerUpdateRequestByUsername(@Param("username") String username);

    //Get a list of all request for a employee (raised by customer)

    @Query(value = "SELECT * FROM customerupdaterequest cur WHERE cur.employeeId = :employeeId", nativeQuery = true)
    Optional<List<CustomerUpdateRequest>> findCustomerUpdateRequestByEmployeeId(@Param("employeeId") String employeeId);

}
