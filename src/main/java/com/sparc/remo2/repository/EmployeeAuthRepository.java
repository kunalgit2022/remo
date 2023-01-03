package com.sparc.remo2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparc.remo2.entity.EmployeeAuth;

public interface EmployeeAuthRepository extends JpaRepository<EmployeeAuth, Integer> {


	boolean existsByUsername(String username);

	EmployeeAuth findByUsername(String mobile);

	//EmployeeAuth findUserNameAndPassword(String login_id);
}
