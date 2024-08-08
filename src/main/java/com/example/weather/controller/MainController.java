package com.example.weather.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.weather.dto.ResultDto;
import com.example.weather.dto.WeatherDto;
import com.example.weather.service.WeatherService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
    
    private final WeatherService weatherService;

    /**
     * 메인 페이지
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
 
    /**
     * 초단기예보조회
     * @param weatherDto
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/getWeather")
    @ResponseBody
    public ResponseEntity<ResultDto> getWeather(@RequestBody WeatherDto weatherDto) throws IOException {
        ResultDto result = new ResultDto();

        result = ResultDto.builder()
                .resultCode("SUCCESS")
                .message("조회가 완료되었습니다.")
                .resultData(weatherService.getWeather(weatherDto))
                .url(null)
                .build();
        
        return new ResponseEntity<ResultDto>(result, HttpStatus.OK);
    }
    
}
