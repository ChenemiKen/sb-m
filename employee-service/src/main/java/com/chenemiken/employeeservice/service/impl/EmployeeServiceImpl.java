package com.chenemiken.employeeservice.service.impl;

import com.chenemiken.employeeservice.dto.ApiResponseDto;
import com.chenemiken.employeeservice.dto.DepartmentDto;
import com.chenemiken.employeeservice.dto.EmployeeDto;
import com.chenemiken.employeeservice.entity.Employee;
import com.chenemiken.employeeservice.exception.ResourceNotFoundException;
import com.chenemiken.employeeservice.repository.EmployeeRepository;
import com.chenemiken.employeeservice.service.ApiClient;
import com.chenemiken.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository employeeRepository;
  private RestTemplate restTemplate;
  private WebClient webClient;
  private ApiClient apiClient;

  @Override
  public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
    Employee employee = new Employee( employeeDto.getId(), employeeDto.getFirstName(),
        employeeDto.getLastName(), employeeDto.getEmail(), employeeDto.getDepartmentCode());

    Employee savedEmployee = employeeRepository.save(employee);

    return new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(),
        savedEmployee.getLastName(), savedEmployee.getEmail(), savedEmployee.getDepartmentCode());

  }

  @Override
  public ApiResponseDto getEmployeeById(Long id) {
    Employee employee = employeeRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException(Employee.class.getCanonicalName(), "id", id.toString()));

//    ResponseEntity<DepartmentDto> response = restTemplate
//        .getForEntity("http://localhost:9090/api/departments/" + employee.getDepartmentCode(),
//            DepartmentDto.class);

//    DepartmentDto departmentDto = response.getBody();

//    DepartmentDto departmentDto = webClient.get()
//        .uri("http://localhost:9090/api/departments/" + employee.getDepartmentCode())
//        .retrieve().bodyToMono(DepartmentDto.class).block();

    DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

    return new ApiResponseDto(employee.getId(), employee.getFirstName(),
        employee.getLastName(), employee.getEmail(), departmentDto);
  }
}
