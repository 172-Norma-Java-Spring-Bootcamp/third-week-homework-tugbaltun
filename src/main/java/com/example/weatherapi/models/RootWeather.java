package com.example.weatherapi.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class RootWeather {
    public double lat;
    public double lon;
    public String timezone;
    public int timezone_offset;
    public Current current;
    public ArrayList<Minutely> minutely;
    public ArrayList<Hourly> hourly;
    public ArrayList<Daily> daily;

    public RootWeather() {
    }

}
