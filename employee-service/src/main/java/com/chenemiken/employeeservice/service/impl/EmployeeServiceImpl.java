package com.chenemiken.employeeservice.service.impl;

import com.chenemiken.employeeservice.dto.EmployeeDto;
import com.chenemiken.employeeservice.entity.Employee;
import com.chenemiken.employeeservice.exception.ResourceNotFoundException;
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
    Employee employee = new Employee( employeeDto.getId(), employeeDto.getFirstName(),
        employeeDto.getLastName(), employeeDto.getEmail());

    Employee savedEmployee = employeeRepository.save(employee);

    return new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(),
        savedEmployee.getLastName(), savedEmployee.getEmail());

  }

  @Override
  public EmployeeDto getEmployeeById(Long id) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException(Employee.class.getCanonicalName(), "id", id.toString()));

    return new EmployeeDto(employee.getId(), employee.getFirstName(),
        employee.getLastName(), employee.getEmail());
  }
}
