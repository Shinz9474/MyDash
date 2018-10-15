package com.MKBot.service;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MKBot.dao.BaseDAO;
import com.MKBot.dao.MKBotEnvironmentDao;
import com.MKBot.domain.MKBotEnvironmentDetails;

@Service
public class MKBotEnvironmentDetailServiceImpl extends BaseDAO implements MKBotEnvironmentDetailService{
	
	@Autowired
	private MKBotEnvironmentDao environmentDao;

	@Override
	public int CreateEnvironment(MKBotEnvironmentDetails environment) throws ParseException {
		
		return environmentDao.createEnvironment(environment);
	}

	@Override
	public List<MKBotEnvironmentDetails> GetAllEnvironments() {
		
		return environmentDao.GetAllEnvironments();
	}
	
	@Override
	public int updateEnvironment(MKBotEnvironmentDetails environment) throws ParseException  {
		return environmentDao.updateEnvironment(environment);
	}
	@Override
	public int deleteEnvironment(MKBotEnvironmentDetails environment) {
		return environmentDao.deleteEnvironment(environment);
				
	}
}
