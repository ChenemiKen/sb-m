package com.chenemiken.organizationservice.controller;

import com.chenemiken.organizationservice.dto.OrganizationDto;
import com.chenemiken.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
  private OrganizationService organizationService;

  @PostMapping()
  public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
    OrganizationDto response = organizationService.saveOrganization(organizationDto);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("{code}")
  public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String code){
    OrganizationDto response = organizationService.getOrganizationByCode(code);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
