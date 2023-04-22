package com.chenemiken.departmentservice.service.impl;

import com.chenemiken.departmentservice.dto.DepartmentDto;
import com.chenemiken.departmentservice.entity.Department;
import com.chenemiken.departmentservice.exception.ResourceNotFoundException;
import com.chenemiken.departmentservice.mapper.DepartmentMapper;
import com.chenemiken.departmentservice.repository.DepartmentRepository;
import com.chenemiken.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl  implements DepartmentService {

  private DepartmentRepository departmentRepository;

  public DepartmentDto saveDepartment(DepartmentDto departmentDto){
    Department department = DepartmentMapper.mapToDepartment(departmentDto);

    Department savedDepartment = departmentRepository.save(department);

    return DepartmentMapper.mapToDepartmentDto(savedDepartment);
  }

  public DepartmentDto getDepartmentByCode(String code) {
    Department department = departmentRepository.findByDepartmentCode(code);
    if(department == null){
      throw new ResourceNotFoundException("department", "code", code);
    }
    return DepartmentMapper.mapToDepartmentDto(department);
  }
}
