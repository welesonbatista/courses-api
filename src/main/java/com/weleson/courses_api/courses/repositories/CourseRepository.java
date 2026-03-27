package com.weleson.courses_api.courses.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weleson.courses_api.courses.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

  Optional<CourseEntity> findByName(String name);

  List<CourseEntity> findByNameOrCategory(String name, String category);

  List<CourseEntity> findAll();

  Optional<CourseEntity> findById(UUID id);

  void deleteById(UUID id);

}
