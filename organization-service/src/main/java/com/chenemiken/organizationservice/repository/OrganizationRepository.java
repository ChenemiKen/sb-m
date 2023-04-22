package com.chenemiken.organizationservice.repository;

import com.chenemiken.organizationservice.entity.Organization;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
  Organization findByOrganizationCode(String organizationCode);
}
