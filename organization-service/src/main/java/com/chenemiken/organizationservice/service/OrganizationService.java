package com.chenemiken.organizationservice.service;

import com.chenemiken.organizationservice.dto.OrganizationDto;
import com.chenemiken.organizationservice.entity.Organization;

public interface OrganizationService {
  public OrganizationDto saveOrganization(OrganizationDto organizationDto);
  public OrganizationDto getOrganizationByCode(String code);
}
