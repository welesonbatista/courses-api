package com.weleson.courses_api.couses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weleson.courses_api.couses.dto.ResponseCourseDTO;
import com.weleson.courses_api.couses.entities.CourseEntity;
import com.weleson.courses_api.couses.useCases.CreateCourseUseCase;
import com.weleson.courses_api.couses.useCases.ListCoursesUseCase;

@RestController
@RequestMapping("/courses")
public class CourseController {

  @Autowired
  CreateCourseUseCase createCourseUseCase = new CreateCourseUseCase();

  @Autowired
  ListCoursesUseCase listCoursesUseCase = new ListCoursesUseCase();

  @PostMapping("/create")
  public ResponseEntity<Object> createCourse(@RequestBody CourseEntity course) {

    try {
      course = this.createCourseUseCase.execute(course);
      var courseResponseDTO = ResponseCourseDTO.builder()
          .name(course.getName())
          .category(course.getCategory())
          .teacher(course.getTeacher())
          .active(course.getActive())
          .created_at(course.getCreated_at())
          .updated_at(course.getUpdated_at())
          .build();
      return ResponseEntity.ok().body(courseResponseDTO);

    } catch (RuntimeException e) {
      return ResponseEntity.status(500).body("Error creating course: " + e.getMessage());
    }

  }

  @GetMapping("/list")
  public ResponseEntity<Object> getCourses(@RequestParam(required = false) String name,
      @RequestParam(required = false) String category) {

    try {
      var courses = this.listCoursesUseCase.execute(name, category);
      return ResponseEntity.ok().body(courses);

    } catch (RuntimeException e) {
      return ResponseEntity.status(500).body("Error listing courses: " + e.getMessage());
    }

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
