package edu.asu.cse545.group5.SBS.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.asu.cse545.group5.SBS.model.AuthRequest;
import edu.asu.cse545.group5.SBS.model.AuthResponse;
import edu.asu.cse545.group5.SBS.service.CredentialStoreService;
import edu.asu.cse545.group5.SBS.service.SBSUserDetailsService;
import edu.asu.cse545.group5.SBS.util.JwtUtil;

@RestController
public class LoginResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired 
    private SBSUserDetailsService userDetailsService;

    @Autowired CredentialStoreService credStore;

    @Autowired 
    private JwtUtil jwtUtil;

    /*@RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public String testUser(){
        CredentialStore testUser4 = new CredentialStore("10011001", "testpwd", "admin");
        credStore.addUser(testUser4);
        return "success";
    }*/

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createJWTAuthToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getId(), authRequest.getPwd()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<String>("Bad Credentials", new HttpHeaders(), HttpStatus.CREATED);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getId());
        
        final String jwtToken = jwtUtil.generateJWTToken(userDetails);

        final String role = credStore.getRole(authRequest.getId());

        return ResponseEntity.ok(new AuthResponse(jwtToken, role));
    }
}
