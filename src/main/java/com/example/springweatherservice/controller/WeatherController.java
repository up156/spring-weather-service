package com.example.springweatherservice.controller;

import com.example.springweatherservice.dto.WeatherDto;
import com.example.springweatherservice.mapper.WeatherMapper;
import com.example.springweatherservice.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    private final WeatherMapper weatherMapper;

    @GetMapping
    public ResponseEntity<WeatherDto> getWeather(@RequestParam String city, Integer days) {
        return ResponseEntity.ok(weatherMapper.weatherToDto(
                weatherService.getWeather(city, days)));

    }
}

