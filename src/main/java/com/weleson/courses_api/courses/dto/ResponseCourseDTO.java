package com.weleson.courses_api.courses.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCourseDTO {

  private UUID id;
  private String name;
  private String category;
  private String teacher;
  private Boolean active;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;
}
