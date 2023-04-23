package com.chenemiken.organizationservice.controller;

import com.chenemiken.organizationservice.dto.OrganizationDto;
import com.chenemiken.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
    name = "Organization Service - Organization Controller",
    description = "Organization controller exposes REST APIs for interacting with the Organization service"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
  private OrganizationService organizationService;

  @Operation(
      summary = "Save Organization",
      description = "Create a new organization"
  )
  @ApiResponse(
      responseCode = "201",
      description = "HTTP Status 201 CREATED"
  )
  @PostMapping()
  public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
    OrganizationDto response = organizationService.saveOrganization(organizationDto);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @Operation(
      summary = "Get Organization",
      description = "Get an organization by the organization code"
  )
  @ApiResponse(
      responseCode = "200",
      description = "HTTP Status 200 SUCCESS"
  )
  @GetMapping("{code}")
  public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String code){
    OrganizationDto response = organizationService.getOrganizationByCode(code);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
