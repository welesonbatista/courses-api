package com.weleson.courses_api.couses.entities;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity (name = "courses")
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;
  private String category;
  private Boolean active;
  
  private LocalDateTime created_at;
  private LocalDateTime updated_at;

}
