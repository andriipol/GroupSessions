package com.group_sessions.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class BadRequestException extends RuntimeException {

  public BadRequestException(Throwable cause) {
    super(cause);
  }

  public BadRequestException(String message) {
    super(message);
  }
}
