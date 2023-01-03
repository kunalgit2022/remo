package com.sparc.remo2.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sparc.remo2.entity.TaskAssign;
import com.sparc.remo2.entity.TaskReporting;
import com.sparc.remo2.repository.ComponentMasterRepository;
import com.sparc.remo2.repository.ProjectMasterRepository;
import com.sparc.remo2.repository.TaskAssignRepository;
import com.sparc.remo2.repository.TaskReportingRepository;
import com.sparc.remo2.request.ReportRequest;
import com.sparc.remo2.request.TaskAssignRequest;
import com.sparc.remo2.response.ComponentResponse;
import com.sparc.remo2.response.FileUploadResponse;
import com.sparc.remo2.response.ProjectResponse;
import com.sparc.remo2.response.TaskAssignResponse;
import com.sparc.remo2.service.FileStorageService;
import com.sparc.remo2.service.MasterService;
import com.sparc.remo2.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private MasterService masterService;
	
	@Autowired
	TaskReportingRepository taskreportingrepo;

	@Autowired
	TaskAssignRepository taskassignRepo;
	
	@Autowired
	FileStorageService fileStorageService;
	
	@Autowired
	private ProjectMasterRepository projMasterRepository;
	
	@Autowired
	private ComponentMasterRepository compoMasterRepository;
	
	@Override
	public String taskReportInsert(ReportRequest reportRequest,MultipartFile file) {
		String msg="";
		TaskReporting task=new TaskReporting();
		if (!reportRequest.equals(null)) {
			task.setProjCode(reportRequest.getProj());
			task.setCompCode(reportRequest.getComp());
			task.setEmpCode(reportRequest.getEcode());
			task.setLatitude(Double.parseDouble(reportRequest.getLat()));
			task.setLongitude(Double.parseDouble(reportRequest.getLon()));
			task.setLocationPhoto(reportRequest.getPhoto());
			task.setQuantity(reportRequest.getQuantity());
			task.setShortNarrative(reportRequest.getShtNar());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Timestamp date1 = (Timestamp) dateFormat.parse(reportRequest.getDate());
				task.setReportDate(date1);
				if(reportRequest.getSyncDate()!=null) {
					Timestamp date2 = (Timestamp) dateFormat.parse(reportRequest.getSyncDate());
					task.setSyncDate(date2);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			task.setDefaultInTime(LocalTime.parse(reportRequest.getFtime()));
			task.setDefaultOutTime( LocalTime.parse(reportRequest.getTotime()));
			if(!file.isEmpty()) {
				FileUploadResponse uploadImage = fileStorageService.uploadImage(file);
				if(!uploadImage.getFileName().isEmpty())
				{
					task.setLocationPhoto(uploadImage.getFileName());
				}
			}
			task=taskreportingrepo.save(task);
			if(task!=null) {
				msg="success";
			}else {
				msg="fail";
			}
		}
		return msg;
	}
	
	@Override
	public String taskReportInsertWithoutImg(ReportRequest reportRequest) {
		String msg="";
		TaskReporting task=new TaskReporting();
		if (!reportRequest.equals(null)) {
			task.setProjCode(reportRequest.getProj());
			task.setCompCode(reportRequest.getComp());
			task.setEmpCode(reportRequest.getEcode());
			task.setLatitude(Double.parseDouble(reportRequest.getLat()));
			task.setLongitude(Double.parseDouble(reportRequest.getLon()));
			task.setLocationPhoto(reportRequest.getPhoto());
			task.setQuantity(reportRequest.getQuantity());
			task.setShortNarrative(reportRequest.getShtNar());
			task.setLocation(reportRequest.getLocation());
			task.setDeptId(reportRequest.getDept());
			task.setJob(reportRequest.getJob());
			task.setLocation(reportRequest.getLocation());
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Timestamp date1 = new Timestamp( dateFormat.parse(reportRequest.getDate()).getTime());
				task.setReportDate(date1);
				if(reportRequest.getSyncDate()!=null) {
					Date date2 = dateFormat.parse(reportRequest.getSyncDate());
					task.setSyncDate(date2);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String ftime=reportRequest.getFtime();
			String[] dateexct=ftime.split(":");
			if( dateexct[0].length()>1 && dateexct[1].length()==1) {
				ftime=dateexct[0]+":"+"0"+dateexct[1];
			}
			else if(dateexct[0].length()==1 && dateexct[1].length()>1) {
				ftime="0"+dateexct[0]+":"+dateexct[1];
			}
			else if( dateexct[0].length()==1 && dateexct[1].length()==1) {
				ftime="0"+dateexct[0]+":"+"0"+dateexct[1];
			}
			task.setDefaultInTime(LocalTime.parse(ftime));
			String otime=reportRequest.getTotime();
			String[] dateexcto=otime.split(":");
			if( dateexcto[0].length()>1 && dateexcto[1].length()==1) {
				otime=dateexcto[0]+":"+"0"+dateexcto[1];
			}
			else if(dateexcto[0].length()==1 && dateexcto[1].length()>1) {
				otime="0"+dateexcto[0]+":"+dateexcto[1];
			}
			else if( dateexcto[0].length()==1 && dateexcto[1].length()==1) {
				otime="0"+dateexcto[0]+":"+"0"+dateexcto[1];
			}
			task.setDefaultOutTime( LocalTime.parse(otime));
			task=taskreportingrepo.save(task);
			if(task!=null) {
				msg="success";
			}else {
				msg="fail";
			}
		}
		return msg;
	}
	@Override
	public String taskassign(TaskAssignRequest assignRequest) {
		String msg="";
		TaskAssign task=new TaskAssign();
		if (!assignRequest.equals(null)) {
			task.setProjCode(assignRequest.getProj());
			task.setCompCode(assignRequest.getComp());
			task.setEmpCode(assignRequest.getEcode());
		    task.setActive(true);
		    task.setCraetedOn(new Date());
	       task.setPhone(assignRequest.getPhone());
	       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date1 = dateFormat.parse(assignRequest.getStdate());
				task.setStartDate(date1);
				Date date2 = dateFormat.parse(assignRequest.getEnddate());
				task.setEndDate(date2);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			task=taskassignRepo.save(task);
			if(task!=null) {
				msg="success";
			}else {
				msg="fail";
			}
		}
		return msg;
	}

	@Override
	public List<TaskAssignResponse> getAllAssignData(String id) {
		/*
		 * List<TaskAssignResponse> taskAssignResponse = new
		 * ArrayList<TaskAssignResponse>(); List<TaskAssign> findByPhone =
		 * taskassignRepo.findByPhone(id); for (TaskAssign taskAssign : findByPhone) {
		 * TaskAssignResponse temp = new TaskAssignResponse();
		 * temp.setProjcode(taskAssign.getProjCode());
		 * temp.setProjName(projMasterRepository.findByProjCode(taskAssign.getProjCode()
		 * ).get().getProjName()); temp.setCompCode(taskAssign.getCompCode());
		 * temp.setCompName(compoMasterRepository.findByCompCode(taskAssign.getCompCode(
		 * )).get().getBillComp()); taskAssignResponse.add(temp); } return
		 * taskAssignResponse;
		 */
		List<TaskAssignResponse> taskAssignResponse = new ArrayList<TaskAssignResponse>();
		List<ProjectResponse> projResponse=masterService.getAllProjByDept(id);
		 for (ProjectResponse projectResponse : projResponse) {
			 TaskAssignResponse temp=null;
			 List<ComponentResponse> CompoResponse=masterService.getAllCompoByProj(projectResponse.getProjCode());
			 for (ComponentResponse componentResponse : CompoResponse) {
				 temp = new TaskAssignResponse();
				 temp.setProjcode(projectResponse.getProjCode());
				 temp.setProjName(projMasterRepository.findByProjCode(projectResponse.getProjCode()).get().getProjName());
				 temp.setCompCode(componentResponse.getCompCode());  
				 temp.setCompName(compoMasterRepository.findByCompCode(componentResponse.getCompCode()).get().getBillComp());
				 taskAssignResponse.add(temp);
			 }
				
		}
		return taskAssignResponse;
	}

	

	
}
