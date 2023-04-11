package com.chenemiken.departmentservice.repository;

import com.chenemiken.departmentservice.entity.Department;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
  Department findByDepartmentCode(String code);
}
