package com.sparc.remo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparc.remo2.entity.EmployeeMaster;


public interface EmployeeRepository extends JpaRepository<EmployeeMaster, Integer> {

	boolean existsByPhone(String mobile);

	EmployeeMaster findByPhone(String mobile);

}
