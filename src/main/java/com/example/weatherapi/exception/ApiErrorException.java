package com.example.weatherapi.exception;

import lombok.Data;

@Data
public class ApiErrorException extends Exception {

  public ApiErrorException() {
    super();
  }

  public ApiErrorException(String message) {
    super(message);
  }

  public ApiErrorException(String message, Throwable cause) {
    super(message, cause);
  }
}
