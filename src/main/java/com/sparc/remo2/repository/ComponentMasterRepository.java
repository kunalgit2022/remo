package com.sparc.remo2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sparc.remo2.entity.ComponentMaster;
import com.sparc.remo2.entity.ProjectMaster;

public interface ComponentMasterRepository extends JpaRepository<ComponentMaster, Integer>{

	//List<ComponentMaster> findByProj(ProjectMaster projectMaster);

	//@Query(value="SELECT * FROM remo_oltp.component_master where pcode=:projcode",nativeQuery = true)
	List<ComponentMaster> findByProj(ProjectMaster projectMaster);

	Optional<ComponentMaster> findByCompCode(String string);



}
