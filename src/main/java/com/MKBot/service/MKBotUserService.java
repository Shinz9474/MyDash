package com.MKBot.service;

import java.util.List;

import com.MKBot.domain.MKBotUser;
import com.MKBot.domain.MKBotUserRestDomain;
import com.MKBot.exceptions.MKBotUserBlockedException;

public interface MKBotUserService {
	
	
	public void Save(MKBotUser user);
	
	public MKBotUser login(String userName,String password) throws MKBotUserBlockedException;
	
	public List<MKBotUser> findAllUsers();
	
	public MKBotUserRestDomain insertMkBotUser(MKBotUser user);
	
	public void updateMkBotUser(MKBotUser user);
	
	public int deleteMkBotUser(String userName);

}
