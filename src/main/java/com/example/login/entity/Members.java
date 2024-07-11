package com.example.login.entity;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
 
@NoArgsConstructor
@Getter
@Entity
public class Members {
 
    // 고유번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    // 아이디
    @Column(nullable = false, updatable = false)
    private String loginId;
 
    // 비밀번호
    @Column(nullable = false)
    private String loginPwd;
 
    // 권한
    @Column(nullable = false)
    private String role;
    
    // 닉네임
    @Column(nullable = false)
    private String nickname;
    
    
    
    @Builder
    public Members(String loginId, String loginPwd, String role, String nickname) {
        this.loginId    = loginId;
        this.loginPwd   = loginPwd;
        this.role       = role;
        this.nickname   = nickname;
    }
 
}