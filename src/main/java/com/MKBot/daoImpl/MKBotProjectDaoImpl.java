package com.MKBot.daoImpl;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.MKBot.dao.BaseDAO;
import com.MKBot.dao.MKBotProjectDao;
import com.MKBot.domain.MKBotProjectDetails;
import com.MKBot.rm.MKBotProjectRm;
import com.MKBot.util.MKBotDateUtil;

@Repository
public class MKBotProjectDaoImpl extends BaseDAO implements MKBotProjectDao{

	@Override
	public int createProject(MKBotProjectDetails project) throws ParseException {
		String sql="insert into MKBotProject(ProjectName,ProjectDescription,CreatedBy,CreatedDate,ModifiedDate,ModifiedBy,isactive)"
				+ " values(:projectName,:projectDesc,:createdBy,:createdDate,:modifiedDate,:modifiedBy,:isActive)";
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("projectName", project.getProjectName());
		m.put("projectDesc", project.getProjectDescription());
		m.put("createdBy", project.getCreatedBy());
		m.put("createdDate", MKBotDateUtil.getCurrentDate());
		m.put("modifiedDate", MKBotDateUtil.getCurrentDate());
		m.put("modifiedBy", project.getModifiedBy());
		m.put("isActive", project.getIsActive());

		KeyHolder kh=new GeneratedKeyHolder();
		
		SqlParameterSource sp=new MapSqlParameterSource(m);
		int count=super.getNamedParameterJdbcTemplate().update(sql, sp,kh);
		
		Integer projectId=kh.getKey().intValue();
		project.setProjectId(projectId);
		return count;
	}

	@Override
	public int updateProject(MKBotProjectDetails project) throws ParseException {
		String sql_update="update mkbotproject set ProjectName= :projectName, ProjectDescription= :ProjectDescription, isActive=:isActive,ModifiedDate= :modifiedDate, ModifiedBy= :modifiedBy  where ProjectId = "+project.getProjectId();
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("projectName", project.getProjectName());
		m.put("ProjectDescription", project.getProjectDescription());
		m.put("modifiedBy", project.getModifiedBy());
		m.put("modifiedDate", MKBotDateUtil.getCurrentDate());
		m.put("isActive", project.getIsActive());
		     KeyHolder kh=new GeneratedKeyHolder();	
		       SqlParameterSource sp=new MapSqlParameterSource(m);
		       int count=super.getNamedParameterJdbcTemplate().update(sql_update,sp,kh);		
		       return count; 
		
	}

	@Override
	public List<MKBotProjectDetails> GetAllProjects() {
		
		String sql="select * from mkbotproject";
		return super.getJdbcTemplate().query(sql,new MKBotProjectRm());
		
	}

	@Override
	public void deleteProject(int projectId) {
		String sql="delete from mkbotproject where projectId="+projectId;
		super.getJdbcTemplate().update(sql);
		
	}

}
