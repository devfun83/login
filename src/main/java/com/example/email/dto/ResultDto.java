package com.example.email.dto;
 
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
 
@Getter
@NoArgsConstructor
public class ResultDto {
 
    private String resultCode   = "ERROR";
    private String message      = "오류가 발생하였습니다.";
    
    @Builder
    public ResultDto (String resultCode, String message, Object resultData, String url) {
        this.resultCode = resultCode;
        this.message    = message;
    }
    
}