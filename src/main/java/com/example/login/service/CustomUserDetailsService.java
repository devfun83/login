package com.example.login.service;
 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
import com.example.login.dto.CustomUserDetails;
import com.example.login.entity.Members;
import com.example.login.repository.MembersRepository;
 
import lombok.RequiredArgsConstructor;
 
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
 
    private final MembersRepository membersRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
        // 회원 정보 조회
        Members memberInfo = membersRepository.findByLoginId(username);
 
        if (memberInfo != null) {
            return new CustomUserDetails(memberInfo);
        }
 
        return null;
    }
 
}