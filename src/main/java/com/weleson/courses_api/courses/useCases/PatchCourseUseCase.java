package com.weleson.courses_api.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weleson.courses_api.courses.repositories.CourseRepository;

@Service
public class PatchCourseUseCase {

  @Autowired
  CourseRepository courseRepository;

  public void execute(UUID id, Boolean active) {
     try {
     if(this.courseRepository.findById(id).isEmpty()) {
        throw new RuntimeException("Course not found");
      }
      if (active != null) {
        courseRepository.findById(id).get().setActive(active);
      }
      courseRepository.save(courseRepository.findById(id).get());
    } catch (Exception e) {
      throw new RuntimeException("Internal server error");
    } 

  }
}
