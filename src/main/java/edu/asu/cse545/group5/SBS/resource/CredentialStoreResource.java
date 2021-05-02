package edu.asu.cse545.group5.SBS.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.asu.cse545.group5.SBS.model.CredentialStore;
import edu.asu.cse545.group5.SBS.service.CredentialStoreService;

@RestController 
@RequestMapping("/credentials")
public class CredentialStoreResource {
    
    private final CredentialStoreService credentialStoreService;

    public CredentialStoreResource(CredentialStoreService credentialStoreService) {
        this.credentialStoreService = credentialStoreService;
    }

    @PostMapping("/addCredentials")
    public ResponseEntity<?> createUser(@RequestBody CredentialStore credentialStore) {
        credentialStoreService.addUser(credentialStore);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
