package com.MKBot.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import org.springframework.jdbc.core.RowMapper;

import com.MKBot.domain.MKBotProjectDetails;

public class MKBotProjectRm implements RowMapper<MKBotProjectDetails>{

	@Override
	public MKBotProjectDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		MKBotProjectDetails project=new MKBotProjectDetails();
		project.setCreatedBy(rs.getString("CreatedBy"));
		project.setCreatedDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format( rs.getTimestamp("CreatedDate")));
		project.setModifiedBy(rs.getString("ModifiedBy"));
		project.setModifiedDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format( rs.getTimestamp("ModifiedDate")));
		project.setProjectDescription(rs.getString("ProjectDescription"));
		project.setProjectId(rs.getInt("ProjectID"));
		project.setProjectName(rs.getString("ProjectName"));
		project.setIsActive(rs.getInt("isActive"));
		return project;
	}
}
