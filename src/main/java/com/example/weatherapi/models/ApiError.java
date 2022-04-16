package com.example.weatherapi.models;

import lombok.Data;

@Data
public class ApiError {
    public String message;
    public int status;

    public ApiError(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public ApiError() {}
}
