package com.MKBot.service;

import java.text.ParseException;
import java.util.List;

import com.MKBot.domain.MKBotEnvironmentDetails;

public interface MKBotEnvironmentDetailService {
	
	public int CreateEnvironment(MKBotEnvironmentDetails environmentnvironment) throws ParseException;
	
	public List<MKBotEnvironmentDetails> GetAllEnvironments();
	
	public int updateEnvironment(MKBotEnvironmentDetails environment) throws ParseException;
	
	public int deleteEnvironment(MKBotEnvironmentDetails environment);

}
