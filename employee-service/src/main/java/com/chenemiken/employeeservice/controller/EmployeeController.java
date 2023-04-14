package com.chenemiken.employeeservice.controller;

import com.chenemiken.employeeservice.dto.ApiResponseDto;
import com.chenemiken.employeeservice.dto.EmployeeDto;
import com.chenemiken.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
  private EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
    EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
  }

  @GetMapping("{id}")
  public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable("id") Long id){
    ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
    return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
  }
}
