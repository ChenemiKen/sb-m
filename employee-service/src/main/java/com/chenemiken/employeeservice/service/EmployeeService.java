package com.chenemiken.employeeservice.service;

import com.chenemiken.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
  EmployeeDto saveEmployee(EmployeeDto employeeDto);

  EmployeeDto getEmployeeById(Long id);
}
