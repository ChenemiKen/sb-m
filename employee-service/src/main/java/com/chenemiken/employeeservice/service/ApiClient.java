package com.chenemiken.employeeservice.service;

import com.chenemiken.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:9090", value = "DEPARTMENT-SERVICE")
public interface ApiClient {
  @GetMapping("api/departments/{department-code}")
  DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}
