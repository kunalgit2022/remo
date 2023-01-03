package com.sparc.remo2.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparc.remo2.entity.InfraCategoryMaster;
import com.sparc.remo2.entity.InfraIssue;
import com.sparc.remo2.entity.TaskAssign;
import com.sparc.remo2.repository.InfraCategoryRepository;
import com.sparc.remo2.repository.InfraIssueRepository;
import com.sparc.remo2.request.IssueRequest;
import com.sparc.remo2.service.IssueService;

@Service
public class IssueServiceImpl implements IssueService{

	@Autowired
	InfraCategoryRepository infraCategoryRepository;
	
	@Autowired
	InfraIssueRepository infraIssueRepository;
	
	@Override
	public List<InfraCategoryMaster> getAllInfraCategory() {
		return infraCategoryRepository.findAll();
	}

	@Override
	public String addIssue(IssueRequest issueRequest) {
		String msg="";
		InfraIssue issue=new InfraIssue();
		if (!issueRequest.equals(null)) {
			issue.setEmpCode(issueRequest.getEcode());
			issue.setDescription(issueRequest.getDescription());
			issue.setIssue(issueRequest.getIssue());
			issue.setCategory(issueRequest.getCtgId());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Timestamp date1 = new Timestamp( dateFormat.parse(issueRequest.getIssueDate()).getTime());
				issue.setReportDate(date1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			issue=infraIssueRepository.save(issue);
			if(issue!=null) {
				msg="success";
			}else {
				msg="fail";
			}
		}
		return msg;
	}

}
