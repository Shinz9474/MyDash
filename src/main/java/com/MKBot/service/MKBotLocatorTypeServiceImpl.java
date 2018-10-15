package com.MKBot.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MKBot.dao.BaseDAO;
import com.MKBot.dao.MKBotEnvironmentDao;
import com.MKBot.dao.MKBotLocatorTypeDao;
import com.MKBot.domain.MKBotEnvironmentDetails;
import com.MKBot.domain.MKBotLocatorType;

@Service
public class MKBotLocatorTypeServiceImpl extends BaseDAO implements MKBotLocatorTypeService {

	@Autowired
	private MKBotLocatorTypeDao locatorTypeDao;

	@Override
	public int createLocatorType(MKBotLocatorType locatorType) throws ParseException {
		
		return locatorTypeDao.createLocatorType(locatorType);
	}

	@Override
	public List<MKBotLocatorType> getAllLocatorTypes() {

		return locatorTypeDao.getAllLocatorTypes();
	}

	@Override
	public int updateLocatorType(MKBotLocatorType locatorType) throws ParseException {

		return locatorTypeDao.updateLocatorType(locatorType);
	}

	@Override
	public int deleteLocatorType(MKBotLocatorType locatorType) {

		return locatorTypeDao.deleteLocatorType(locatorType);
	}

	@Override
	public List<MKBotLocatorType> getInsertedLoactorType() {

		return locatorTypeDao.getInsertedLoactorType();
	}


}
