package com.weleson.courses_api.exeptions;

public class CourseNotFoundExeption extends RuntimeException {
  public CourseNotFoundExeption() {
    super("Course not found");
  }

}
