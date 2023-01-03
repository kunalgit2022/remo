package com.sparc.remo2.service;

import java.util.List;

import com.sparc.remo2.entity.InfraCategoryMaster;
import com.sparc.remo2.request.IssueRequest;



public interface IssueService {

	List<InfraCategoryMaster> getAllInfraCategory();

	String addIssue(IssueRequest issueRequest);
	
}
