package com.sparc.remo2.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sparc.remo2.request.ReportRequest;
import com.sparc.remo2.request.TaskAssignRequest;
import com.sparc.remo2.response.TaskAssignResponse;

public interface TaskService {

	String taskReportInsert(ReportRequest reportRequest, MultipartFile file);

	String taskassign(TaskAssignRequest assignRequest);

	List<TaskAssignResponse> getAllAssignData(String id);

	String taskReportInsertWithoutImg(ReportRequest reportRequest);

}
