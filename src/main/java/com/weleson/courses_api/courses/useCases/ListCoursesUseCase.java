package com.weleson.courses_api.courses.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weleson.courses_api.courses.dto.ResponseCourseDTO;
import com.weleson.courses_api.courses.repositories.CourseRepository;
import com.weleson.courses_api.exeptions.CourseNotFoundExeption;

@Service
public class ListCoursesUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public List<ResponseCourseDTO> execute(String name, String category) {

    if (name == null && category == null) {
      if (courseRepository.findAll().isEmpty()) {
        throw new CourseNotFoundExeption();
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

      throw new CourseNotFoundExeption();
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
