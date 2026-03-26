package com.weleson.courses_api.couses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weleson.courses_api.couses.entities.CourseEntity;
import com.weleson.courses_api.couses.useCases.CreateCourseUseCase;

@RestController
@RequestMapping("/courses")
public class CourseController {

  @Autowired
  CreateCourseUseCase createCourseUseCase = new CreateCourseUseCase();

  @PostMapping("/create")
  public String createCourse(@RequestBody CourseEntity course) {

    createCourseUseCase.execute(course);

    return "Course created successfully!";
  }

  @GetMapping("/list-courses")
  public String getCourses() {
    return "List of courses";
  }

  @PutMapping("/update-course")
  public String updateCourse(@RequestBody CourseEntity course) {
    return "Course updated successfully!";
  }

  @DeleteMapping("/delete-course")
  public String deleteCourseById() {
    return "Course deleted successfully!";
  }

}
