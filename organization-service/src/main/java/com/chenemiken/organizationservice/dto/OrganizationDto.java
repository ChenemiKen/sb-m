package com.chenemiken.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Organization DTO Model Information")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
  private long id;
  @Schema(description = "Organization Name")
  private String organizationName;
  @Schema(description = "Organization Description")
  private String organizationDescription;
  @Schema(description = "Organization Code")
  private String organizationCode;
  @Schema(description = "Date Created")
  private LocalDateTime createdDate;
}
