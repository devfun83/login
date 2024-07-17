package com.example.oauth2.dto;
 
import java.util.Map;
 
public class NaverDto implements OAuth2Dto {
 
    private final String provider = "naver";
    private final Map<String, Object> attribute;
    
    public NaverDto(Map<String, Object> attribute) {
        this.attribute = (Map<String, Object>) attribute.get("response");
    }
 
    @Override
    public String getUserid() {
        return provider + "_" + attribute.get("id").toString();
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
        return attribute.get("id").toString();
    }
 
}