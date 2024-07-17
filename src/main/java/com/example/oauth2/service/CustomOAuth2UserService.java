package com.example.oauth2.service;
 
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
 
import com.example.oauth2.dto.CustomOAuth2User;
import com.example.oauth2.dto.GoogleDto;
import com.example.oauth2.dto.NaverDto;
import com.example.oauth2.dto.OAuth2Dto;
import com.example.oauth2.entity.Members;
import com.example.oauth2.repository.MembersRepository;
 
import lombok.RequiredArgsConstructor;
 
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
 
    private final MembersRepository membersRepository;
    
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
 
        System.out.println("=============================");
        System.out.println("oAuth2User : " + oAuth2User);
        System.out.println("=============================");
 
        // 공급자
        String registrationId   = userRequest.getClientRegistration().getRegistrationId();
        
        OAuth2Dto oAuth2Dto     = null;
        
        if (registrationId.equals("google")) {
            oAuth2Dto   = new GoogleDto(oAuth2User.getAttributes());
        }
        else if (registrationId.equals("naver")) {
            oAuth2Dto   = new NaverDto(oAuth2User.getAttributes());
        }
        else {
            return null;
        }
 
        // 회원 정보 조회
        Members memberInfo = membersRepository.findByUserid(oAuth2Dto.getUserid());
 
        if (memberInfo == null) {
            memberInfo = Members.builder()
                    .userid(oAuth2Dto.getUserid())
                    .email(oAuth2Dto.getEmail())
                    .username(oAuth2Dto.getUsername())
                    .role("ROLE_USER")
                    .provider(oAuth2Dto.getProvider())
                    .providerId(oAuth2Dto.getProviderId())
                    .build();
 
            membersRepository.save(memberInfo); // 회원가입
        }
 
        return new CustomOAuth2User(memberInfo);
 
    }
 
}