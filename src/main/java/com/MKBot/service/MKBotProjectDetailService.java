package com.MKBot.service;

import java.text.ParseException;
import java.util.List;

import com.MKBot.domain.MKBotProjectDetails;

public interface MKBotProjectDetailService {
	
	public int CreateProject(MKBotProjectDetails project) throws ParseException;
	
	public List<MKBotProjectDetails> GetAllProjects();
	
	public void deleteProject(int projectId);
	
	public void updateProject(MKBotProjectDetails project) throws ParseException;

}
