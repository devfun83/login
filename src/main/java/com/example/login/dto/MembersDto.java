package com.example.login.dto;
 
import com.example.login.entity.Members;

import lombok.Getter;
import lombok.Setter;
 
@Setter
@Getter
public class MembersDto {
 
    private String loginId;     // 아이디
    private String loginPwd;    // 비밀번호
    private String nickname;    // 닉네임
    private String role;        // 권한
 
 
    public Members toEntity() {
        Members builder = Members.builder()
                .loginId(loginId)
                .loginPwd(loginPwd)
                .nickname(nickname)
                .role(role) 
                .build();
        return builder;
    }
    
}