package com.weleson.courses_api.courses.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weleson.courses_api.courses.dto.ResponseCourseDTO;
import com.weleson.courses_api.courses.dto.UpdateCourseDTO;
import com.weleson.courses_api.courses.entities.CourseEntity;
import com.weleson.courses_api.courses.useCases.CreateCourseUseCase;
import com.weleson.courses_api.courses.useCases.DeteleCourseUseCase;
import com.weleson.courses_api.courses.useCases.ListCoursesUseCase;
import com.weleson.courses_api.courses.useCases.PatchCourseUseCase;
import com.weleson.courses_api.courses.useCases.UpdateCourseUseCase;

@RestController
@RequestMapping("/courses")
public class CourseController {

  @Autowired
  CreateCourseUseCase createCourseUseCase = new CreateCourseUseCase();

  @Autowired
  ListCoursesUseCase listCoursesUseCase = new ListCoursesUseCase();

  @Autowired
  UpdateCourseUseCase updateCourseUseCase = new UpdateCourseUseCase();

  @Autowired
  DeteleCourseUseCase deteleCourseUseCase = new DeteleCourseUseCase();

  @Autowired
  PatchCourseUseCase patchCourseUseCase = new PatchCourseUseCase();

  @PostMapping("/create")
  public ResponseEntity<Object> createCourse(@RequestBody CourseEntity course) {

    try {
      course = this.createCourseUseCase.execute(course);
      var courseResponseDTO = ResponseCourseDTO.builder()
          .id(course.getId())
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

  @PutMapping("/update")
  public ResponseEntity<Object> updateCourse(@RequestParam UUID id, @RequestBody UpdateCourseDTO updateCourseDTO) {

    try {
      this.updateCourseUseCase.execute(id, updateCourseDTO);
    } catch (RuntimeException e) {
      return ResponseEntity.status(500).body("Error updating course: " + e.getMessage());
    }

    return ResponseEntity.ok().body(updateCourseDTO);
  }

  @DeleteMapping("/delete")
  public String deleteCourseById(@RequestParam UUID id) {
    try {
      this.deteleCourseUseCase.execute(id);
      return "Course deleted successfully";
    } catch (RuntimeException e) {
      return "Error deleting course: " + e.getMessage();
    }

  }

  @PatchMapping("/patch")
  public String patchCourse(@RequestParam UUID id, @RequestParam Boolean active) {
    try {
      this.patchCourseUseCase.execute(id, active);
      return "Course patched successfully";
    } catch (RuntimeException e) {
      return "Error patching course: " + e.getMessage();
    }
  }

}