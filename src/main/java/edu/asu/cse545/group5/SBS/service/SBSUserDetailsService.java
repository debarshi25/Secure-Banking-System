package edu.asu.cse545.group5.SBS.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.asu.cse545.group5.SBS.model.CredentialStore;

@Service
public class SBSUserDetailsService implements UserDetailsService{
     
     @Autowired
     private CredentialStoreService credentialStoreService; 
     
     @Override
     public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
           CredentialStore credentialStore = credentialStoreService.getUser(userName);
           String password = credentialStore.getPassword(); 
           return new User(userName,password, new ArrayList<>());  
    }
}
