package com.example.weatherapi.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Hourly{
    public int dt;
    public double temp;
    public double feels_like;
    public int pressure;
    public int humidity;
    public double dew_point;
    public double uvi;
    public int clouds;
    public int visibility;
    public double wind_speed;
    public int wind_deg;
    public double wind_gust;
    public ArrayList<Weather> weather;
    public double pop;
    public Rain rain;
}

