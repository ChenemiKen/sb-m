package com.chenemiken.departmentservice.mapper;

import com.chenemiken.departmentservice.dto.DepartmentDto;
import com.chenemiken.departmentservice.entity.Department;

public class DepartmentMapper {
  public static DepartmentDto mapToDepartmentDto(Department department){
    return new DepartmentDto(department.getId(), department.getDepartmentName(),
        department.getDepartmentDescription(), department.getDepartmentCode());
  }

  public static Department mapToDepartment(DepartmentDto departmentDto){
    return new Department(
        departmentDto.getId(), departmentDto.getDepartmentName(),
        departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode()
    );
  }
}
