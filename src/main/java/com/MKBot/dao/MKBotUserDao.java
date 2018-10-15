package com.MKBot.dao;

import java.util.List;

import com.MKBot.domain.MKBotUser;
import com.MKBot.domain.MKBotUserRestDomain;
import com.MKBot.exceptions.MKBotUserBlockedException;

public interface MKBotUserDao {
	
	public static final Integer USER_STATUS_ACTIVE=1;
	public static final Integer USER_STATUS_BLOCKED=2;
	
	public void Save(MKBotUser user);
	
	public MKBotUser getUser(String userName,String password) throws MKBotUserBlockedException;
	
	public List<MKBotUser> findAllUsers();
	
	public MKBotUserRestDomain insertMkBotUser(MKBotUser user);
	
	public void updateMkBotUser(MKBotUser user);
	
	public int deleteMkBotUser(String  userName);

}
