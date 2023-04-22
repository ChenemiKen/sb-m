package com.chenemiken.employeeservice.service.impl;

import com.chenemiken.employeeservice.dto.ApiResponseDto;
import com.chenemiken.employeeservice.dto.DepartmentDto;
import com.chenemiken.employeeservice.dto.EmployeeDto;
import com.chenemiken.employeeservice.dto.OrganizationDto;
import com.chenemiken.employeeservice.entity.Employee;
import com.chenemiken.employeeservice.exception.ResourceNotFoundException;
import com.chenemiken.employeeservice.mapper.EmployeeMapper;
import com.chenemiken.employeeservice.repository.EmployeeRepository;
import com.chenemiken.employeeservice.service.ApiClient;
import com.chenemiken.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

  @Override
  public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
    Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

    Employee savedEmployee = employeeRepository.save(employee);

    return EmployeeMapper.mapToEmployeeDto(savedEmployee);

  }

//  @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
  @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
  @Override
  public ApiResponseDto getEmployeeById(Long id) {
    logger.info("inside getEmployeeById method ---->");
    Employee employee = employeeRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException(Employee.class.getCanonicalName(), "id", id.toString()));

    DepartmentDto departmentDto = webClient.get()
        .uri("http://localhost:9090/api/departments/" + employee.getDepartmentCode())
        .retrieve().bodyToMono(DepartmentDto.class).block();

    OrganizationDto organizationDto = webClient.get()
        .uri("http://localhost:9092/api/organizations/" + employee.getOrganizationCode())
        .retrieve().bodyToMono(OrganizationDto.class).block();


    return new ApiResponseDto(employee.getId(), employee.getFirstName(),
        employee.getLastName(), employee.getEmail(), departmentDto, organizationDto);
  }

  public ApiResponseDto getDefaultDepartment(Long id, Exception e) {
    logger.info("inside getDefaultDepartment method ---->");
    Employee employee = employeeRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException(Employee.class.getCanonicalName(), "id", id.toString()));

    DepartmentDto departmentDto = new DepartmentDto("Default", "Default generic dept", "dflt");
    OrganizationDto organizationDto = new OrganizationDto("Default", "Default generic organization", "dflt");

    return new ApiResponseDto(employee.getId(), employee.getFirstName(),
        employee.getLastName(), employee.getEmail(), departmentDto, organizationDto);
  }
}
