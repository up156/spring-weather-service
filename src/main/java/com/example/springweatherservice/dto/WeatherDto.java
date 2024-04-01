package com.example.springweatherservice.dto;

import lombok.*;

import java.time.Instant;
@Data
@Getter
@Setter
public class WeatherDto {

    private Long id;

    private Instant dateTime;

    private String city;

    private String currentWeather;

    private String forecast;

    private Integer days;

}
