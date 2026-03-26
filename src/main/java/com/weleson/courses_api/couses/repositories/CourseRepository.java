package com.weleson.courses_api.couses.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weleson.courses_api.couses.entities.CourseEntity;

public interface CourseRepository extends JpaRepository <CourseEntity, UUID> {

  //CREATE

  //READ
  Optional<CourseEntity> findByName(String name);
  List<CourseEntity> findByNameOrCategory(String name, String category);
  List<CourseEntity> findAll();

  //UPDATE

  //DELETE









}
