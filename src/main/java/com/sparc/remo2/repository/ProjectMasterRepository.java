package com.sparc.remo2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparc.remo2.entity.DepartmentMaster;
import com.sparc.remo2.entity.ProjectMaster;

public interface ProjectMasterRepository extends JpaRepository<ProjectMaster, Integer>{

	List<ProjectMaster> findByDept(DepartmentMaster departmentMaster);

	Optional<ProjectMaster> findByProjCode(String projcode);


	//ProjectMaster findByProjCode(String projcode);

	

}
