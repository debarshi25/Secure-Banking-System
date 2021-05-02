package edu.asu.cse545.group5.SBS.model;

public class AuthResponse {
    
    private final String jwtToken;
    private final String role;

    public AuthResponse(String jwtToken, String role) {
        this.jwtToken = jwtToken;
        this.role = role;
    }
    
    public String getJwtToken() {
        return jwtToken;
    }

    public String getRole() {
        return role;
    }

}
