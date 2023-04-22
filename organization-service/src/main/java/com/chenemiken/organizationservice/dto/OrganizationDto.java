package com.chenemiken.organizationservice.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
  private long id;
  private String organizationName;
  private String organizationDescription;
  private String organizationCode;
  private LocalDateTime createdDate;
}
