package com.MKBot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MKBot.dao.BaseDAO;
import com.MKBot.dao.MKBotUserDao;
import com.MKBot.domain.MKBotUser;
import com.MKBot.domain.MKBotUserRestDomain;
import com.MKBot.exceptions.MKBotUserBlockedException;

@Service
public class MKBotUserServiceImpl extends BaseDAO implements MKBotUserService{
	
	@Autowired
	private MKBotUserDao userDao;

	@Override
	public void Save(MKBotUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MKBotUser login(String userName, String password)throws MKBotUserBlockedException {
		return userDao.getUser(userName, password);
	}

	@Override
	public List<MKBotUser> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public MKBotUserRestDomain insertMkBotUser(MKBotUser user) {
	
		return 	userDao.insertMkBotUser(user);
		
	}

	@Override
	public void updateMkBotUser(MKBotUser user) {
		userDao.updateMkBotUser(user);
		
	}

	@Override
	public int deleteMkBotUser(String userName) {
		// TODO Auto-generated method stub
		return userDao.deleteMkBotUser(userName);
	}

	

}
