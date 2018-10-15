package com.MKBot.dao;

import java.text.ParseException;
import java.util.List;

import com.MKBot.domain.MKBotEnvironmentDetails;

public interface MKBotEnvironmentDao {
	
	public int createEnvironment(MKBotEnvironmentDetails environment) throws ParseException;
	
	public int updateEnvironment(MKBotEnvironmentDetails environment) throws ParseException;
	
	public List<MKBotEnvironmentDetails> GetAllEnvironments();
	
	public int deleteEnvironment(MKBotEnvironmentDetails environment);
	

}
