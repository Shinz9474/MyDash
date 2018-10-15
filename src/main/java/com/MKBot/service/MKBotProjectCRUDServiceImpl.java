package com.MKBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MKBot.dao.BaseDAO;
import com.MKBot.dao.MKBotProjectCRUDDao;
import com.MKBot.domain.MKBotProjectCRUD;

@Service
public class MKBotProjectCRUDServiceImpl  extends BaseDAO implements MKBotProjectCRUDService{
	
	@Autowired
	MKBotProjectCRUDDao project;

	@Override
	public int saveProject(MKBotProjectCRUD pCRUD) {
		
		project.saveProject(pCRUD);
		
		return 0;
	}

}
