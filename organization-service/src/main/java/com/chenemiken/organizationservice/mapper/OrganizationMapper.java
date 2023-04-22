package com.chenemiken.organizationservice.mapper;

import com.chenemiken.organizationservice.dto.OrganizationDto;
import com.chenemiken.organizationservice.entity.Organization;

public class OrganizationMapper {
  public static Organization mapToEntity(OrganizationDto organizationDto){
    return new Organization(organizationDto.getId(), organizationDto.getOrganizationName(),
        organizationDto.getOrganizationDescription(), organizationDto.getOrganizationCode(),
        organizationDto.getCreatedDate());
  }

  public static OrganizationDto mapToDto(Organization organization){
    return new OrganizationDto(organization.getId(), organization.getOrganizationName(),
        organization.getOrganizationDescription(), organization.getOrganizationCode(),
        organization.getCreatedDate());
  }
}