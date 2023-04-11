package com.chenemiken.departmentservice.service;

import com.chenemiken.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
  public DepartmentDto saveDepartment(DepartmentDto departmentDto);

  public DepartmentDto getDepartmentByCode(String code);
}
