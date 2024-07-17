package com.example.oauth2.entity;
 
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
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // 아이디
    @Column(nullable = false)
    private String userid;  // Spring Security username
 
    // 이메일 주소
    @Column(nullable = false)
    private String email;
    
    // 이름
    @Column(nullable = false)
    private String username;    // 만일 null값이 들어올 경우 예외처리 필요
 
    // 권한
    @Column(nullable = false)
    private String role;
    
    // 공급자
    @Column(nullable = false)
    private String provider;
    
    // 공급자 고유 ID
    @Column(nullable = false)
    private String providerId;
    
    
    @Builder
    public Members(String userid, String email, String username, String role, String provider, String providerId) {
        this.userid     = userid;
        this.email      = email;
        this.username   = username;
        this.role       = role;
        this.provider   = provider;
        this.providerId = providerId;
    }
 
}