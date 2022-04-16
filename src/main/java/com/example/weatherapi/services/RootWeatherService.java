package com.example.weatherapi.services;

import com.example.weatherapi.exception.ApiErrorException;
import com.example.weatherapi.models.RootWeather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RootWeatherService {

    private final RestTemplate restTemplate;

    public RootWeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public RootWeather getWeather( double lat, double lon, String part, String appKey ) throws ApiErrorException {
        //Connect between current api and openweathermap with using RestTemplate
        RootWeather rootWeather = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&exclude="+part+"&appid="+appKey, RootWeather.class);
        //return RootWeather
        return rootWeather;
    }
}
