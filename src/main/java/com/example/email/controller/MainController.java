package com.example.email.controller;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
import com.example.email.dto.MailDto;
import com.example.email.dto.ResultDto;
import com.example.email.service.MailService;
 
import lombok.RequiredArgsConstructor;
 
@RequiredArgsConstructor
@Controller
public class MainController {
 
    private final MailService mailService;
    
    /**
     * 메인 페이지
     * @return
     */
    @GetMapping("/")
    public String getMethodName() {
        return "index";
    }
    
    /**
     * 메일 발송
     * @param mailDto
     * @return
     */
    @PostMapping(value = "/send_mail", produces = "application/json; charset=utf8")
    public ResponseEntity<ResultDto> sendMail(@RequestBody MailDto mailDto) {
        
        ResultDto result = new ResultDto();
        
        try {
            // 메일 발송 대상자
            List<Map<String, String>> userList = new ArrayList<Map<String, String>>();
            
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", "김철수");
            map.put("email", "test@nate.com");
            userList.add(map);
            
            map = new HashMap<String, String>();
            map.put("name", "장철수");
            map.put("email", "test@gmail.com");
            userList.add(map);
            
            map = new HashMap<String, String>();
            map.put("name", "이영희");
            map.put("email", "test@gmail.com");
            userList.add(map);
            
            map = new HashMap<String, String>();
            map.put("name", "홍길동");
            map.put("email", "test@daum.net");
            userList.add(map);
            
            for (int i = 0; i < userList.size(); i++) {
                mailService.sendMail(mailDto, userList.get(i));
            }
 
            result = ResultDto.builder()
                    .resultCode("SUCCESS")
                    .message("발송이 완료되었습니다.")
                    .build();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return new ResponseEntity<ResultDto>(result, HttpStatus.OK);
    }
    
}