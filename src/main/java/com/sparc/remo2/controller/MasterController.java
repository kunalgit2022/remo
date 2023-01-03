package com.sparc.remo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sparc.remo2.entity.DepartmentMaster;
import com.sparc.remo2.response.ComponentResponse;
import com.sparc.remo2.response.ProjectResponse;
import com.sparc.remo2.service.MasterService;


@RestController
@RequestMapping(path="/api/v1/masters")
public class MasterController {
	@Autowired
	private MasterService masterService;

	
	@GetMapping(path="/getAllDept")
	public  List<DepartmentMaster> getAllDept() {
		return masterService.getAllDept();
	}
	@GetMapping(path="/getAllProjByDept")
	public  List<ProjectResponse> getAllProjByDept(@RequestParam String deptId) {
		return masterService.getAllProjByDept(deptId);
	}
	@GetMapping(path="/getAllCompByProj")
	public  List<ComponentResponse> getAllCompoByProj(@RequestParam String projcode) {
		return masterService.getAllCompoByProj(projcode);
	}
	
}
