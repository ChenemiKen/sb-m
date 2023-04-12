package com.chenemiken.departmentservice.service.impl;

import com.chenemiken.departmentservice.dto.DepartmentDto;
import com.chenemiken.departmentservice.entity.Department;
import com.chenemiken.departmentservice.repository.DepartmentRepository;
import com.chenemiken.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl  implements DepartmentService {
  private ModelMapper modelMapper;
  private DepartmentRepository departmentRepository;

  public DepartmentDto saveDepartment(DepartmentDto departmentDto){
    Department department = new Department(
        departmentDto.getId(), departmentDto.getDepartmentName(),
        departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode()
    );

    Department savedDepartment = departmentRepository.save(department);

    return new DepartmentDto(
        savedDepartment.getId(), savedDepartment.getDepartmentName(),
        savedDepartment.getDepartmentDescription(), savedDepartment.getDepartmentCode()
    );

  }

  public DepartmentDto getDepartmentByCode(String code) {
    Department department = departmentRepository.findByDepartmentCode(code);
    return new DepartmentDto(
        department.getId(), department.getDepartmentName(),
        department.getDepartmentDescription(), department.getDepartmentCode()
    );
  }
}
