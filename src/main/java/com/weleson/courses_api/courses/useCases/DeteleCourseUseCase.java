package com.weleson.courses_api.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weleson.courses_api.courses.repositories.CourseRepository;
import com.weleson.courses_api.exeptions.CourseNotFoundExeption;

@Service
public class DeteleCourseUseCase {

  @Autowired
  CourseRepository courseRepository;

  public void execute(UUID id) {
    try {
      if (courseRepository.findById(id).isEmpty()) {
        throw new CourseNotFoundExeption();
      }
      courseRepository.deleteById(id);
    } catch (Exception e) {
      throw new RuntimeException("Internal server error: " + e.getMessage());
    }
  }

}
