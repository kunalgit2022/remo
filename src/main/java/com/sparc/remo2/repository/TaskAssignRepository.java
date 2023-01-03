package com.sparc.remo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sparc.remo2.entity.TaskAssign;

public interface TaskAssignRepository extends JpaRepository<TaskAssign, Integer>{

	@Query(value="SELECT * FROM remo_oltp.task_assign where phone=:id",nativeQuery = true)
	List<TaskAssign> findByPhone(String id);

}
