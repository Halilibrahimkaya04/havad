package org.hdwork.havad.service;

import org.hdwork.havad.Repository.WeatherRepository;
import org.hdwork.havad.model.WeatherDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    @Value("${weather.api.url}")
    private String weatherApiUrl;

    @Value("${weather.api.key}")
    private String apiKey;  // @Value annotation ile doğru key alınmalı

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
    }

    public WeatherDocument getWeatherByCity(String city) {
        // MongoDB'den veri çek
        Optional<WeatherDocument> weatherDocumentOptional = weatherRepository.findByName(city);
        if (weatherDocumentOptional.isPresent()) {
            return weatherDocumentOptional.get();
        }

        // API'den veri çek
        String url = String.format("%s?q=%s&appid=%s&units=metric", weatherApiUrl, city, apiKey);
        WeatherDocument weatherDocument = null;

        try {
            weatherDocument = restTemplate.getForObject(url, WeatherDocument.class);
            if (weatherDocument != null) {
                weatherRepository.save(weatherDocument); // MongoDB'ye kaydet
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new RuntimeException("City not found: " + city);
            } else {
                throw new RuntimeException("API error: " + e.getMessage());
            }
        }

        return weatherDocument;
    }
}