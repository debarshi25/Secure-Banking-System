package edu.asu.cse545.group5.SBS.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.asu.cse545.group5.SBS.model.CredentialStore;
import edu.asu.cse545.group5.SBS.repo.CredentialStoreRepo;

@Service
public class CredentialStoreService {
    
    private final CredentialStoreRepo credentialStoreRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    public CredentialStoreService(CredentialStoreRepo credentialStoreRepo) {
        this.credentialStoreRepo = credentialStoreRepo;
    }

    public void addUser(CredentialStore creds) {
        creds.setPassword(encoder.encode(creds.getPassword()));
        credentialStoreRepo.saveAndFlush(creds);
    }

    public CredentialStore getUser(String id) {
        Optional <CredentialStore> user = credentialStoreRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        } 
    }

    public String getRole(String id) {
        Optional <CredentialStore> user = credentialStoreRepo.findById(id);
        if(user.isPresent()) {
            return user.get().getRole();
        } else {
            return null;
        } 
    }
    
}
