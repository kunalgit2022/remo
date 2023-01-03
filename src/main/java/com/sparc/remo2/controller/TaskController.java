package com.sparc.remo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparc.remo2.request.ReportRequest;
import com.sparc.remo2.request.TaskAssignRequest;
import com.sparc.remo2.response.MessageResponse;
import com.sparc.remo2.response.TaskAssignResponse;
import com.sparc.remo2.service.TaskService;

@RestController
@RequestMapping(path = "/api/v1/task")
public class TaskController {
	
	@Autowired
	TaskService taskService;

	@PostMapping("/reportwithimg")
	public ResponseEntity<?> taskReportInsert(@RequestParam(value = "model", required = false) String reportModel,@RequestParam("file") MultipartFile file) 
			throws JsonMappingException, JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		ReportRequest reportRequest = mapper.readValue(reportModel, ReportRequest.class);
		return ResponseEntity.ok(new MessageResponse(taskService.taskReportInsert(reportRequest,file)));
    }
	@PostMapping("/report")
	public ResponseEntity<?> reportwithoutimg(@RequestBody ReportRequest reportRequest) 
	{
		return ResponseEntity.ok(new MessageResponse(taskService.taskReportInsertWithoutImg(reportRequest)));
    }
	@PostMapping("/taskassign")
	public ResponseEntity<?> taskassign(@RequestBody TaskAssignRequest assignRequest) {
		return ResponseEntity.ok(new MessageResponse(taskService.taskassign(assignRequest)));
    }
	@GetMapping(path="/getAllAssignData")
	public  List<TaskAssignResponse> getAllAssignData(@RequestParam String id) {
		return taskService.getAllAssignData(id);
	}
	
}
