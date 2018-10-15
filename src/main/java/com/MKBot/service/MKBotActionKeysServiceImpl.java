package com.MKBot.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MKBot.dao.MKBotActionKeywordsDao;
import com.MKBot.domain.MKBotActionKeywords;

@Service
public class MKBotActionKeysServiceImpl implements MKBotActionKeysService {

	@Autowired
	MKBotActionKeywordsDao mkbotActionKeys;
	
	@Override
	public int createActionKey(MKBotActionKeywords ActionKey)throws ParseException {
		return mkbotActionKeys.createActionKey(ActionKey);
	}

	@Override
	public int deleteActionKey(Integer ActionKey) {
		return mkbotActionKeys.deleteActionKey(ActionKey);
	}

	@Override
	public int updateActionKey(MKBotActionKeywords ActionKey) {
		return mkbotActionKeys.updateActionKey(ActionKey);
	}

	@Override
	public List<MKBotActionKeywords> getAllActionKeys() {		
		return mkbotActionKeys.getAllActionKeys();
	}

}
