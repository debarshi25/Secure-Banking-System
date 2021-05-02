package edu.asu.cse545.group5.SBS.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.asu.cse545.group5.SBS.model.CredentialStore;

public interface CredentialStoreRepo extends JpaRepository<CredentialStore, String> {
    
}

