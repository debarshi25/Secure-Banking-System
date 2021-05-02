package edu.asu.cse545.group5.SBS.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.asu.cse545.group5.SBS.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    @Query(value = "SELECT username FROM customers WHERE username LIKE :id", nativeQuery = true)
    List<String> findCustomersByUsernameContaining(@Param("id") String id);
    
    Optional<Customer> findCustomerByUsername(String username);

    void deleteCustomerByUsername(String username);
}
