package com.sparc.remo2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparc.remo2.entity.ComponentMaster;
import com.sparc.remo2.entity.DepartmentMaster;
import com.sparc.remo2.entity.EmployeeMaster;
import com.sparc.remo2.entity.ProjectMaster;
import com.sparc.remo2.repository.ComponentMasterRepository;
import com.sparc.remo2.repository.DeptMasterRepository;
import com.sparc.remo2.repository.EmployeeRepository;
import com.sparc.remo2.repository.ProjectMasterRepository;
import com.sparc.remo2.response.AssignResponse;
import com.sparc.remo2.response.ComponentResponse;
import com.sparc.remo2.response.ProjectResponse;
import com.sparc.remo2.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DeptMasterRepository deptMasterRepository;
	
	@Autowired
	private ProjectMasterRepository projMasterRepository;
	
	@Autowired
	private ComponentMasterRepository compoMasterRepository;
	
	@Override
	public AssignResponse getAssignEmpNameDeptNameByMobile(String mobile) {
		AssignResponse assignResponse=new AssignResponse();	
		EmployeeMaster emp=employeeRepository.findByPhone(mobile);
		if(emp!=null) {
			assignResponse.setEmpName(emp.getEmpName());
			assignResponse.setEcode(emp.getEmpCode());
			assignResponse.setDeptNmae((emp.getDept().getDeptName()));
			assignResponse.setDeptCode(emp.getDept().getDeptId());
			assignResponse.setDefaultInTime(emp.getDefaultInTime().toString());
			assignResponse.setDefaultOutTime(emp.getDefaultOutTime().toString());
		}
		return assignResponse;
	}

	@Override
	public List<DepartmentMaster> getAllDept() {
		return deptMasterRepository.findAll();
	}

	@Override
	public List<ProjectResponse> getAllProjByDept(String deptId) {
		List<ProjectResponse> projectResponse = new ArrayList<ProjectResponse>();
		List<ProjectMaster> findByDept = projMasterRepository.findByDept(deptMasterRepository.findById(deptId).get());
		for (ProjectMaster projectMaster : findByDept) {
			ProjectResponse temp = new ProjectResponse();
			temp.setProjCode(projectMaster.getProjCode());
			temp.setProjName(projectMaster.getProjName());
			projectResponse.add(temp);
		}
		return projectResponse;
	}

	@Override
	public List<ComponentResponse> getAllCompoByProj(String projcode) {
		List<ComponentResponse> componentResponse = new ArrayList<ComponentResponse>();
		ProjectMaster projectMaster = projMasterRepository.findByProjCode(projcode).get();
		List<ComponentMaster> findByProjCode =compoMasterRepository.findByProj(projectMaster);
				for(ComponentMaster componentMaster :findByProjCode) 
				{ 
				  ComponentResponse temp1 = new ComponentResponse();
				  temp1.setCompCode(componentMaster.getCompCode());
				  temp1.setBillComp(componentMaster.getBillComp()); 
				  componentResponse.add(temp1);
		       } 
		return componentResponse;
	}

}
