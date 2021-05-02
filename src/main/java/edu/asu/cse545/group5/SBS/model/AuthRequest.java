package edu.asu.cse545.group5.SBS.model;

public class AuthRequest {

    private String id;
    private String pwd;
    
    public AuthRequest() {

    }
    
    public AuthRequest(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }
    
    public String getPwd() {
        return pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public void setId(String id) {
        this.id = id;
    }
      
}
