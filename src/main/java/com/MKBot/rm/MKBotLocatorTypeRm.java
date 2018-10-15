package com.MKBot.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.MKBot.domain.MKBotLocatorType;

public class MKBotLocatorTypeRm implements RowMapper<MKBotLocatorType> 
{

	@Override
	public MKBotLocatorType mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MKBotLocatorType locatorType = new MKBotLocatorType();
		
		locatorType.setLocatorTypeID(rs.getInt("LOCATOR_TYPE_ID"));
		locatorType.setTypeName(rs.getString("TYPE_NAME"));
		locatorType.setCreatedBy(rs.getString("CREATED_BY"));
		locatorType.setCreatedDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format( rs.getTimestamp("CREATEDDATE")));
		locatorType.setModifiedBy(rs.getString("MODIFIEDBY"));
		locatorType.setModifiedDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format( rs.getTimestamp("MODIFIEDDATE")));
		return locatorType;
	}

}
