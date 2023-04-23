package com.chenemiken.departmentservice.controller;

import com.chenemiken.departmentservice.dto.DepartmentDto;
import com.chenemiken.departmentservice.service.DepartmentService;
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
    name = "Department Service - Department Controller",
    description = "Department controller exposes REST APIs for interacting with the Department service"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
  private DepartmentService departmentService;

  @Operation(
      summary = "Save Department",
      description = "Create a new department"
  )
  @ApiResponse(
      responseCode = "201",
      description = "HTTP Status 201 CREATED"
  )
  @PostMapping
  public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
    DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);

    return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
  }

  @Operation(
      summary = "Get Department",
      description = "Get a department by the department code"
  )
  @ApiResponse(
      responseCode = "200",
      description = "HTTP Status 200 SUCCESS"
  )
  @GetMapping("{department-code}")
  public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String code){
    DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
    return new ResponseEntity<>(departmentDto, HttpStatus.OK);
  }
}
