package com.MKBot.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.MKBot.domain.MKBotEnvironmentDetails;

public class MKBotEnvironmentRm implements RowMapper<MKBotEnvironmentDetails>{

	@Override
	public MKBotEnvironmentDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		MKBotEnvironmentDetails environment=new MKBotEnvironmentDetails();
		environment.setCreatedBy(rs.getString("CreatedBy"));
		environment.setCreatedDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format( rs.getTimestamp("CreatedDate")));
		environment.setModifiedBy(rs.getString("ModifiedBy"));
		environment.setModifiedDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format( rs.getTimestamp("ModifiedDate")));
		environment.setenvironmentDescription(rs.getString("Env_Description"));
		environment.setenvironmentId(rs.getInt("Env_Id"));
		environment.setenvironmentName(rs.getString("Env_Name"));
		return environment;
	}
}
