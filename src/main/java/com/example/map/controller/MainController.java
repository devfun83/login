package com.example.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	/**
	 * 메인 페이지
	 * @return
	 */
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
}
