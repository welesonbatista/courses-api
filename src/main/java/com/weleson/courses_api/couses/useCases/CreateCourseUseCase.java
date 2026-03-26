package com.weleson.courses_api.couses.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weleson.courses_api.couses.entities.CourseEntity;
import com.weleson.courses_api.couses.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(CourseEntity course) {

    this.courseRepository.findByNameOrCategory(course.getName(), course.getCategory())
        .ifPresent(c -> {
          throw new RuntimeException("Course with the same name or category already exists.");
        });

    return this.courseRepository.save(course);
  }

}
