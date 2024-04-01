package com.example.springweatherservice.service;

import com.example.springweatherservice.client.WeatherClient;
import com.example.springweatherservice.entity.Weather;
import com.example.springweatherservice.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;
    private final WeatherRepository weatherRepository;

    public Weather getWeather(String city, Integer days) {

        log.info("getWeather in Weather service called with city: {} and days: {}", city, days);

        List<Weather> result = weatherRepository.findWeatherByCityAndDays(city, days);
        Collections.reverse(result);
        Weather weather = result.stream().findFirst().orElse(null);

        if (weather == null || weather.getDateTime().isBefore((Instant.now().minus(15, ChronoUnit.MINUTES)))) {
            List<String> reply = weatherClient.getWeather(city, days);
            return saveWeather(city, days, reply);
        } else {
            return weather;
        }
    }

    public Weather saveWeather(String city, Integer days, List<String> reply) {
        log.info("saveWeather in Weather service called with city: {} and days: {} and reply: {}", city, days, reply.toString());
        Weather weather = new Weather();
        weather.setCity(city);
        weather.setDateTime(Instant.now());
        weather.setDays(days);
        weather.setCurrentWeather(reply.get(0));
        weather.setForecast(reply.get(1));
        return weatherRepository.save(weather);

    }
}
