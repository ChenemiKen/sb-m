package com.chenemiken.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto{
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private DepartmentDto department;
  private OrganizationDto organization;

}
