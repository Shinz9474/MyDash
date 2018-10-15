package com.MKBot.dao;

import java.text.ParseException;
import java.util.List;

import com.MKBot.domain.MKBotLocatorType;;

public interface MKBotLocatorTypeDao {

	public int createLocatorType(MKBotLocatorType locatorType) throws ParseException;
	
	public List<MKBotLocatorType> getAllLocatorTypes();
	
	public int updateLocatorType(MKBotLocatorType locatorType) throws ParseException;
	
	public int deleteLocatorType(MKBotLocatorType locatorType);
	
	public List<MKBotLocatorType> getInsertedLoactorType();

}
