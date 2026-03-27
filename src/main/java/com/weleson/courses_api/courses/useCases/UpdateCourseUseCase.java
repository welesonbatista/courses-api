package com.weleson.courses_api.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weleson.courses_api.courses.dto.UpdateCourseDTO;
import com.weleson.courses_api.courses.repositories.CourseRepository;
import com.weleson.courses_api.exeptions.CourseNotFoundExeption;

@Service
public class UpdateCourseUseCase {

  @Autowired
  CourseRepository courseRepository;

  public void execute(UUID id, UpdateCourseDTO updateCourseDTO) {
    try {
      if (courseRepository.findById(id).isEmpty()) {
        throw new CourseNotFoundExeption();
      }

      if (updateCourseDTO.getName() != null) {
        courseRepository.findById(id).get().setName(updateCourseDTO.getName());
      }

      if (updateCourseDTO.getCategory() != null) {
        courseRepository.findById(id).get().setCategory(updateCourseDTO.getCategory());
      }

      if (updateCourseDTO.getTeacher() != null) {
        courseRepository.findById(id).get().setTeacher(updateCourseDTO.getTeacher());
      }
      courseRepository.save(courseRepository.findById(id).get());

    } catch (Exception e) {
      throw new RuntimeException("Internal server error");

    }
  }
}
