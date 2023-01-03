package com.sparc.remo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparc.remo2.entity.DepartmentMaster;
import com.sparc.remo2.entity.InfraCategoryMaster;
import com.sparc.remo2.request.IssueRequest;
import com.sparc.remo2.request.ReportRequest;
import com.sparc.remo2.response.MessageResponse;
import com.sparc.remo2.service.IssueService;
import com.sparc.remo2.service.MasterService;

@RestController
@RequestMapping(path="/api/v1/issue")
public class IssueController {
	@Autowired
	private IssueService issueService;

	
	@GetMapping(path="/getAllInfraCategory")
	public  List<InfraCategoryMaster> getAllInfraCategory() {
		return issueService.getAllInfraCategory();
	}
	
	@PostMapping("/addIssue")
	public ResponseEntity<?> addIssue(@RequestBody IssueRequest issueRequest) 
	{
		return ResponseEntity.ok(new MessageResponse(issueService.addIssue(issueRequest)));
    }
}
