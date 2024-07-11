package com.example.login.dto;
 
import java.util.ArrayList;
import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
import com.example.login.entity.Members;
 
import lombok.Getter;
import lombok.RequiredArgsConstructor;
 
@RequiredArgsConstructor
@Getter
public class CustomUserDetails implements UserDetails {
    
    private final Members members;
    
    // 권한 반환
    @Override
    public Collection getAuthorities() {
 
        Collection collection = new ArrayList<>();
 
        collection.add(new GrantedAuthority() {
 
            @Override
            public String getAuthority() {
                return members.getRole();
            }
        });
 
        return collection;
    }
    
    // 비밀번호 반환
    @Override
    public String getPassword() {
        //return members.getPassword();
        return members.getLoginPwd();
    }
 
    // 아이디 반환
    @Override
    public String getUsername() {
        //return members.getUsername();
        return members.getLoginId();
    }
 
    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    // 계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    // 패스워드 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    // 계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        return true;
    }
 
}