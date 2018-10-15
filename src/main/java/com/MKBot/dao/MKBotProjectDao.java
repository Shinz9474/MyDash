package com.MKBot.dao;

import java.text.ParseException;
import java.util.List;

import com.MKBot.domain.MKBotProjectDetails;

public interface MKBotProjectDao {
	
	public int createProject(MKBotProjectDetails project) throws ParseException;
	
	public int updateProject(MKBotProjectDetails project) throws ParseException;
	
	public List<MKBotProjectDetails> GetAllProjects();
	
	public void deleteProject(int projectId);
	
	

}
