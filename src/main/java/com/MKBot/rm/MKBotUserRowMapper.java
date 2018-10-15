package com.MKBot.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.MKBot.domain.MKBotUser;

public class MKBotUserRowMapper implements RowMapper<MKBotUser>{

	@Override
	public MKBotUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		MKBotUser user=new MKBotUser();
		user.setFirstName(rs.getString("FirstName"));
		user.setId(rs.getInt("ID"));
		user.setIsActive(rs.getInt("IsActive"));
		user.setLastName(rs.getString("LastName"));
		user.setUserName(rs.getString("UserName"));
		user.setPassword(rs.getString("Password"));
		return user;
	}
}
