package com.sparc.remo2.service;

import java.util.List;

import com.sparc.remo2.entity.DepartmentMaster;
import com.sparc.remo2.response.AssignResponse;
import com.sparc.remo2.response.ComponentResponse;
import com.sparc.remo2.response.ProjectResponse;

public interface MasterService {

	AssignResponse getAssignEmpNameDeptNameByMobile(String username);

	List<DepartmentMaster> getAllDept();

	List<ProjectResponse> getAllProjByDept(String deptId);

	List<ComponentResponse> getAllCompoByProj(String projcode);

}
