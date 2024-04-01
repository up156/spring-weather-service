package com.example.springweatherservice.mapper;

import com.example.springweatherservice.dto.WeatherDto;
import com.example.springweatherservice.entity.Weather;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WeatherMapper {

    WeatherDto weatherToDto(Weather weather);

    Weather DtoToWeather(WeatherDto weatherDto);
}
