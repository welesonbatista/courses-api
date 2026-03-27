package com.weleson.courses_api.exeptions;

public class InvalidDataExeption extends RuntimeException {
  public InvalidDataExeption() {
    super("Invalid data, verify the field or the value");
  }
}
