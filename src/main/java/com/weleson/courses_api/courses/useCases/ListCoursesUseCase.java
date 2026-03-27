package com.weleson.courses_api.courses.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.weleson.courses_api.courses.dto.ResponseCourseDTO;
import com.weleson.courses_api.courses.repositories.CourseRepository;

@Service
public class ListCoursesUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public List<ResponseCourseDTO> execute(String name, String category) {

    if (name == null && category == null) {
      if (courseRepository.findAll().isEmpty()) {
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "No courses have been created yet");
      }
      return this.courseRepository.findAll().stream().map((course) -> {
        return ResponseCourseDTO.builder()
            .id(course.getId())
            .name(course.getName())
            .category(course.getCategory())
            .teacher(course.getTeacher())
            .active(course.getActive())
            .created_at(course.getCreated_at())
            .updated_at(course.getUpdated_at())
            .build();
      }).toList();
    }

    if (this.courseRepository.findByNameOrCategory(name, category).isEmpty()) {

      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          "No courses found with the provided name or category");
    }
    return this.courseRepository.findByNameOrCategory(name, category).stream().map((course) -> {
      return ResponseCourseDTO.builder()
          .id(course.getId())
          .name(course.getName())
          .category(course.getCategory())
          .teacher(course.getTeacher())
          .active(course.getActive())
          .created_at(course.getCreated_at())
          .updated_at(course.getUpdated_at())
          .build();
    }).toList();
  }

}
