package com.example.weatherapi.controllers;

import com.example.weatherapi.exception.ApiErrorException;
import com.example.weatherapi.models.RootWeather;
import com.example.weatherapi.services.RootWeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("api")
@Slf4j
public class RootWeatherController {

    private final RootWeatherService rootWeatherService;

    public RootWeatherController(RootWeatherService rootWeatherService) {
        this.rootWeatherService = rootWeatherService;
    }

    //HTTP GET REQUEST for WEATHER FORECAST includes Current/Minutely/Hourly/Daily
    @GetMapping("weather/{lat}/{lon}/{part}/{appKey}")
    public ResponseEntity<?> getWeather(@PathVariable double lat, @PathVariable double lon,
                                        @PathVariable String part, @PathVariable String appKey) throws ApiErrorException {
        //throw Error Messages via ApiErrorException
        if (lat == 0.0 || lon == 0.0) {
            //if lat and lon values equals 0.0 then throw exception
            return ResponseEntity.badRequest().body("lat and lon values can not be 0.0.");
        }
        if (!part.contains("current") && !part.contains("minutely") && !part.contains("hourly") && !part.contains("daily") ) {
            //if exclude doesn't contains one of these words(current,minutely,hourly,daily) then throw exception
            return ResponseEntity.badRequest().body("exclude value can not be '"+part+"' you should use one of these 'current','minutely','hourly',daily'.");
        }
        if (appKey.length() != 32) {
            //if  length of appid is not equal 32 then throw exception
            return ResponseEntity.badRequest().body("appid can not be lass or higher than 32.");
        }

        return ResponseEntity.ok(rootWeatherService.getWeather(lat, lon, part, appKey));
    }
}
