package com.weleson.courses_api.couses.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weleson.courses_api.couses.dto.ResponseCourseDTO;
import com.weleson.courses_api.couses.repositories.CourseRepository;

@Service
public class ListCoursesUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public List<ResponseCourseDTO> execute(String name, String category) {

    if (name == null && category == null) {
      return this.courseRepository.findAll().stream().map((course) -> {
        return ResponseCourseDTO.builder()
            .name(course.getName())
            .category(course.getCategory())
            .teacher(course.getTeacher())
            .active(course.getActive())
            .created_at(course.getCreated_at())
            .updated_at(course.getUpdated_at())
            .build();
      }).toList();
    }
    return this.courseRepository.findByNameOrCategory(name, category).stream().map((course) -> {
      return ResponseCourseDTO.builder()
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
