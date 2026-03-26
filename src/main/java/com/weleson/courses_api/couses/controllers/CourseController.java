package com.weleson.courses_api.couses.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

  @PostMapping("/create-course")
  public String createCourse() {
    return "Course created successfully!";
  }

  @GetMapping("/list-courses")
  public String getCourses() {
    return "List of courses";
  }

  @PutMapping("/update-course")
  public String updateCourse() {
    return "Course updated successfully!";
  }

  @DeleteMapping("/delete-course")
  public String deleteCourse() {
    return "Course deleted successfully!";
  }

}
