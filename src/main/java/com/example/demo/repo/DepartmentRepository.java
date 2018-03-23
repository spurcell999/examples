package com.example.demo.repo;

import com.example.demo.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by e026459 on 3/23/2018.
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
