package com.example.email.dto;
 
import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
public class MailDto {
    
    private String title;       // 제목
    private String contents;    // 내용
    
    private String company;     // 상호명
    private String name;        // 받는 사람 이름
    private String email;       // 상호명
    private String link;        // 버튼 링크
    
}