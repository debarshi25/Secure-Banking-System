package edu.asu.cse545.group5.SBS.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.asu.cse545.group5.SBS.model.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

    Optional<Account> findAccountByAccountNum(Long id);
    
}
