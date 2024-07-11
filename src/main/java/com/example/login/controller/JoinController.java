package com.example.login.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import com.example.login.dto.MembersDto;
import com.example.login.service.JoinService;
 
import lombok.RequiredArgsConstructor;
 
@RequiredArgsConstructor
@Controller
public class JoinController {
 
    private final JoinService joinService;
    
    /**
     * 회원가입
     * @return
     */
    @GetMapping("/join")
    public String join() {
        return "join";
    }
    
    /**
     * 회원가입 > 저장
     * @param membersDto
     * @return
     */
    @PostMapping("/joinProc")
    public String joinProc(MembersDto membersDto) {
 
        if (!joinService.joinProc(membersDto)) {
            return "redirect:/";
        }
        else {
            return "redirect:/join";
        }
 
    }
 
}