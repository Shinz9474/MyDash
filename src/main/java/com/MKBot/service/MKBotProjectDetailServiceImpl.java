package com.MKBot.service;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MKBot.dao.BaseDAO;
import com.MKBot.dao.MKBotProjectDao;
import com.MKBot.domain.MKBotProjectDetails;

@Service
public class MKBotProjectDetailServiceImpl extends BaseDAO implements MKBotProjectDetailService{
	
	@Autowired
	private MKBotProjectDao projectDao;

	@Override
	public int CreateProject(MKBotProjectDetails project) throws ParseException {
		
		return projectDao.createProject(project);
	}

	@Override
	public List<MKBotProjectDetails> GetAllProjects() {
		
		return projectDao.GetAllProjects();
	}

	@Override
	public void deleteProject(int projectId) {
		projectDao.deleteProject(projectId);
		
	}

	@Override
	public void updateProject(MKBotProjectDetails project) throws ParseException {
		projectDao.updateProject(project);
	}

}
