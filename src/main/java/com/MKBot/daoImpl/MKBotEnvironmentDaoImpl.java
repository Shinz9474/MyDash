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
import com.MKBot.dao.MKBotEnvironmentDao;
import com.MKBot.domain.MKBotEnvironmentDetails;
import com.MKBot.rm.MKBotEnvironmentRm;
import com.MKBot.util.MKBotDateUtil;

@Repository
public class MKBotEnvironmentDaoImpl extends BaseDAO implements MKBotEnvironmentDao{

	@Override
	public int createEnvironment(MKBotEnvironmentDetails environment) throws ParseException {
		String sql="insert into mkbottest_environments(Env_Name,Env_Description,CreatedBy,CreatedDate,ModifiedDate,ModifiedBy)"
				+ " values(:environmentName,:environmentDesc,:createdBy,:createdDate,:modifiedDate,:modifiedBy)";
		Map<String,Object> m=new HashMap<String,Object>();
		//m.put("environmentId", environment.getenvironmentId());
		m.put("environmentName", environment.getenvironmentName());
		m.put("environmentDesc", environment.getenvironmentDescription());
		m.put("createdBy", environment.getCreatedBy());
		m.put("createdDate", MKBotDateUtil.getCurrentDate());
		m.put("modifiedDate", MKBotDateUtil.getCurrentDate());
		m.put("modifiedBy", environment.getModifiedBy());
		

		KeyHolder kh=new GeneratedKeyHolder();
		
		SqlParameterSource sp=new MapSqlParameterSource(m);
		int count=super.getNamedParameterJdbcTemplate().update(sql, sp,kh);
		
		Integer environmentId=kh.getKey().intValue();
		environment.setenvironmentId(environmentId);
		return count;
	}

	@Override
	public int updateEnvironment(MKBotEnvironmentDetails environment) throws ParseException {
					
			String sql_update="update mkbottest_environments set Env_Name= :environmentName, Env_Description= :environmentDesc, ModifiedDate= :modifiedDate, ModifiedBy= :modifiedBy  where Env_Id = "+environment.getenvironmentId();
			Map<String,Object> m=new HashMap<String,Object>();
			m.put("environmentName", environment.getenvironmentName());
			m.put("environmentDesc", environment.getenvironmentDescription());
			m.put("modifiedBy", environment.getModifiedBy());
			m.put("modifiedDate", MKBotDateUtil.getCurrentDate());
			     KeyHolder kh=new GeneratedKeyHolder();	
			       SqlParameterSource sp=new MapSqlParameterSource(m);
			       int count=super.getNamedParameterJdbcTemplate().update(sql_update,sp,kh);		
			       return count; 
    	
	}

	@Override
	public List<MKBotEnvironmentDetails> GetAllEnvironments() {
		
		String sql_env="select * from mkbottest_environments";
		return super.getJdbcTemplate().query(sql_env,new MKBotEnvironmentRm());
		
	}

	@Override
	public int deleteEnvironment(MKBotEnvironmentDetails environment){
	
	String sql_del="delete  from mkbottest_environments where Env_Id ="+environment.getenvironmentId();
	 Map<String,Object> m=new HashMap<String,Object>();
		m.put("environmentId", environment.getenvironmentId());	
       KeyHolder kh=new GeneratedKeyHolder();	
       SqlParameterSource sp=new MapSqlParameterSource(m);
       int count=super.getNamedParameterJdbcTemplate().update(sql_del, sp,kh);		
       return count;    
								
		
	}

}
