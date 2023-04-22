package com.chenemiken.organizationservice.service.impl;

import com.chenemiken.organizationservice.dto.OrganizationDto;
import com.chenemiken.organizationservice.entity.Organization;
import com.chenemiken.organizationservice.exception.ResourceNotFoundException;
import com.chenemiken.organizationservice.mapper.OrganizationMapper;
import com.chenemiken.organizationservice.repository.OrganizationRepository;
import com.chenemiken.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
  private OrganizationRepository organizationRepository;
  @Override
  public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
    Organization organization = OrganizationMapper.mapToEntity(organizationDto);
    Organization savedOrganization = organizationRepository.save(organization);
    return OrganizationMapper.mapToDto(savedOrganization);
  }

  @Override
  public OrganizationDto getOrganizationByCode(String code) {
    Organization organization = organizationRepository.findByOrganizationCode(code);
    if(organization == null){
      throw new ResourceNotFoundException("organization", "code", code);
    }
    return OrganizationMapper.mapToDto(organization);
  }
}
