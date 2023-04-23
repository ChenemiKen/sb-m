package com.chenemiken.employeeservice.controller;

import com.chenemiken.employeeservice.dto.ApiResponseDto;
import com.chenemiken.employeeservice.dto.EmployeeDto;
import com.chenemiken.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
    name = "Employee Service - Employee Controller",
    description = "Employee controller exposes REST APIs for interacting with the Employee service"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
  private EmployeeService employeeService;

  @Operation(
      summary = "Save Employee",
      description = "Create a new Employee"
  )
  @ApiResponse(
      responseCode = "201",
      description = "HTTP Status 201 CREATED"
  )
  @PostMapping
  public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
    EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
  }

  @Operation(
      summary = "Get Employee",
      description = "Get a employee by the id"
  )
  @ApiResponse(
      responseCode = "200",
      description = "HTTP Status 200 SUCCESS"
  )
  @GetMapping("{id}")
  public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable("id") Long id){
    ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
    return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
  }
}
