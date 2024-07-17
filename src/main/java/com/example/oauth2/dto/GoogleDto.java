package com.example.oauth2.dto;
 
import java.util.Map;
 
public class GoogleDto implements OAuth2Dto {
 
    private final String provider = "google";
    private final Map<String, Object> attribute;
    
    public GoogleDto(Map<String, Object> attribute) {
        this.attribute = attribute;
    }
 
    @Override
    public String getUserid() {
        return provider + "_" + attribute.get("sub").toString();
    }
    
    @Override
    public String getUsername() {
        return attribute.get("name").toString();
    }
 
    @Override
    public String getEmail() {
        return attribute.get("email").toString();
    }
    
    @Override
    public String getProvider() {
        return provider;
    }
    
    @Override
    public String getProviderId() {
        return attribute.get("sub").toString();
    }
 
}