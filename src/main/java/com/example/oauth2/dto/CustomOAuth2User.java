package com.example.oauth2.dto;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
 
import com.example.oauth2.entity.Members;
 
import lombok.Getter;
import lombok.RequiredArgsConstructor;
 
@RequiredArgsConstructor
@Getter
public class CustomOAuth2User implements OAuth2User {
 
    private final Members members;
 
    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return members.getRole();
            }
        });
 
        return collection;
    }
 
    @Override
    public String getName() {
        return members.getUserid();
    }
 
}