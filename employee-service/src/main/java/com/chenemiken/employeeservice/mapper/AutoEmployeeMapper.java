package com.chenemiken.employeeservice.mapper;

import com.chenemiken.employeeservice.dto.EmployeeDto;
import com.chenemiken.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoEmployeeMapper {
  AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

//  @Mapping(source = "email", target = "emailAddress")
  EmployeeDto mapToEmployeeDto(Employee employee);
  Employee mapToEmployee(EmployeeDto employeeDto);
}
