package com.weleson.courses_api.couses.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCourseDTO {

  private String name;
  private String category;
  private String teacher;
  private Boolean active;
  private LocalDateTime created_at;
  private LocalDateTime updated_at;

}
