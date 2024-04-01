package com.example.springweatherservice.repository;

import com.example.springweatherservice.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    List<Weather> findWeatherByCityAndDays(String city, Integer days);
}
