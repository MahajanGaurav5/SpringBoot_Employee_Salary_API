package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entities.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>
{

}
