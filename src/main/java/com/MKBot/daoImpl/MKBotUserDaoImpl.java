package com.MKBot.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.MKBot.dao.BaseDAO;
import com.MKBot.dao.MKBotUserDao;
import com.MKBot.domain.MKBotErrorClass;
import com.MKBot.domain.MKBotUser;
import com.MKBot.domain.MKBotUserRestDomain;
import com.MKBot.exceptions.MKBotUserBlockedException;
import com.MKBot.rm.MKBotUserRowMapper;

@Repository
public class MKBotUserDaoImpl extends BaseDAO implements MKBotUserDao{
	

	@Override
	public void Save(MKBotUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MKBotUser getUser(String userName, String password) throws MKBotUserBlockedException {
		String sql="select ID,FirstName,LastName,IsActive,UserName,Password  from mkbotusers where UserName=:un and Password=:pwd";
		Map<String,String> m=new HashMap<String,String>();
		m.put("un", userName);
		m.put("pwd", password);
		try {
			MKBotUser user= super.getNamedParameterJdbcTemplate().queryForObject(sql, m, new MKBotUserRowMapper());
			if(user.getIsActive().equals(MKBotUserDao.USER_STATUS_BLOCKED)) {
				throw new MKBotUserBlockedException("User Blocked. Please contact Your Adminstrator.");
			}
			else {
				return user;	
			}
		}
		catch(EmptyResultDataAccessException e) {
			return null;	
		}		
	}

	@Override
	public List<MKBotUser> findAllUsers() {
		String sql="select ID,FirstName,LastName,IsActive,UserName,Password from mkbotusers";
		return super.getJdbcTemplate().query(sql,new MKBotUserRowMapper());
	}

	@Override
	public MKBotUserRestDomain insertMkBotUser(MKBotUser user) {
		MKBotUserRestDomain UserRestDomain=new MKBotUserRestDomain();
		try {
		String sql="insert into mkbotusers(FirstName,LastName,IsActive,UserName,Password) "
				+ "values(:firstName,:lastName,:isActive,:userName,:password);";
		
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("firstName", user.getFirstName());
		m.put("lastName", user.getLastName());
		m.put("isActive", user.getIsActive());
		m.put("userName", user.getUserName());
		m.put("password", user.getPassword());
		

		KeyHolder kh=new GeneratedKeyHolder();
		
		SqlParameterSource sp=new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql, sp,kh);
		
		Integer userId=kh.getKey().intValue();
		user.setId(userId);
		
	
		
		UserRestDomain.setMessage("Inserted Successfully");
		
		}
		catch(DuplicateKeyException d) {
			MKBotErrorClass error=new MKBotErrorClass();
			error.setErrorMessage("Duplicate User Name");
			error.setSysErrorMessage(d.getMessage());
			error.setStackTrace(d.getStackTrace().toString());
			UserRestDomain.setMessage("Unable to Create User");
			
			UserRestDomain.setError(error);
			
		}
		
		return UserRestDomain;
		
	}

	@Override
	public void updateMkBotUser(MKBotUser user) {
		String sql="update mkbotusers set FirstName=:firstName, LastName=:lastName, IsActive=:isActive, Password=:password"
				+ " where UserName=:userName";
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("firstName", user.getFirstName());
		m.put("lastName", user.getLastName());
		m.put("isActive", user.getIsActive());
		m.put("userName", user.getUserName());
		m.put("password", user.getPassword());
		SqlParameterSource sp=new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql, sp);
		
	}

	@Override
	public int deleteMkBotUser(String userName) {
		
		String sql="delete from MKBotUsers where UserName=?";
		return super.getJdbcTemplate().update(sql,userName);
	}

	
}
