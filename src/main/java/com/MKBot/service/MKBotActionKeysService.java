package com.MKBot.service;

import java.text.ParseException;
import java.util.List;

import com.MKBot.domain.MKBotActionKeywords;

public interface MKBotActionKeysService {

	public int createActionKey(MKBotActionKeywords ActionKey) throws ParseException;
	
	public int deleteActionKey(Integer ActionKey);
	
	public int updateActionKey(MKBotActionKeywords ActionKey);
	
	public List<MKBotActionKeywords> getAllActionKeys();

}
