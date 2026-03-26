package com.weleson.courses_api.couses.entities;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Data
@Entity (name = "courses")
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "Course name is required")
  @Length(max = 50, message = "Course name must be less than 100 characters")
  private String name;

  @NotBlank(message = "Course category is required")
  private String category;

  @NotBlank(message = "Course teacher is required")
  private String teacher;

  private Boolean active;
  
  @CreationTimestamp
  private LocalDateTime created_at;

  @UpdateTimestamp
  private LocalDateTime updated_at;

}
