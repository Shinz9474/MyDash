package com.MKBot.service;

import java.text.ParseException;
import java.util.List;

import com.MKBot.domain.MKBotEnvironmentDetails;
import com.MKBot.domain.MKBotLocatorType;

public interface MKBotLocatorTypeService {

	public int createLocatorType(MKBotLocatorType locatorType) throws ParseException;
	
	public List<MKBotLocatorType> getAllLocatorTypes();
	
	public int updateLocatorType(MKBotLocatorType locatorType) throws ParseException;
	
	public int deleteLocatorType(MKBotLocatorType locatorType);
	
	public List<MKBotLocatorType> getInsertedLoactorType();
}
