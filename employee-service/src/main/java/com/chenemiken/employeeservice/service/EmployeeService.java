package com.chenemiken.employeeservice.service;

import com.chenemiken.employeeservice.dto.ApiResponseDto;
import com.chenemiken.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
  EmployeeDto saveEmployee(EmployeeDto employeeDto);

  ApiResponseDto getEmployeeById(Long id);
}
