package com.weleson.courses_api.courses.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weleson.courses_api.courses.entities.CourseEntity;
import com.weleson.courses_api.courses.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(CourseEntity course) {

    this.courseRepository.findByName(course.getName())
        .ifPresent((optionalObjectNotFound) -> {
          throw new RuntimeException("Course with name " + course.getName() + " already exists!");
        });

    return this.courseRepository.save(course);

  }

}
