package org.hdwork.havad.controller;

import org.hdwork.havad.model.WeatherDocument;
import org.hdwork.havad.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<WeatherDocument> getWeather(@RequestParam String city) {
        if (city == null || city.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Şehir boşsa 400 Bad Request döndür
        }

        try {
            WeatherDocument weather = weatherService.getWeatherByCity(city);
            return ResponseEntity.ok(weather);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Şehir bulunamazsa 404 döndür
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
