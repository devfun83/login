package com.example.oauth2.dto;
 
public interface OAuth2Dto {
 
    String getUserid(); // Spring Security username
    
    String getUsername();
    
    String getEmail();
            
    String getProvider();
 
    String getProviderId();
    
}