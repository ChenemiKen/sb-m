package com.chenemiken.employeeservice.service.impl;

import com.chenemiken.employeeservice.dto.EmployeeDto;
import com.chenemiken.employeeservice.entity.Employee;
import com.chenemiken.employeeservice.mapper.AutoEmployeeMapper;
import com.chenemiken.employeeservice.repository.EmployeeRepository;
import com.chenemiken.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository employeeRepository;

  @Override
  public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//    Employee employee = new Employee( employeeDto.getId(), employeeDto.getFirstName(),
//        employeeDto.getLastName(), employeeDto.getEmail());
    Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

    Employee savedEmployee = employeeRepository.save(employee);

    return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);

//    return new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(),
//        savedEmployee.getLastName(), savedEmployee.getEmail());

  }

  @Override
  public EmployeeDto getEmployeeById(Long id) {
    Employee employee = employeeRepository.findById(id).get();

    return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);

//    return new EmployeeDto(employee.getId(), employee.getFirstName(),
//        employee.getLastName(), employee.getEmail());
  }
}
