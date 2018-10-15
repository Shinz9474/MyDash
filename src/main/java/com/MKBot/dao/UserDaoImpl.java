package com.MKBot.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.MKBot.domain.User;

@Repository
public class UserDaoImpl extends BaseDAO implements UserDao {

	@Override
	public void Save(User u) {
		try {
		String sql="Insert into User(name,phone,email,address,loginName,password,role,loginStatus) "
				+ "values(:name,:phone,:email,:address,:loginName,:password,:role,:loginStatus)";
		Map<String, Object> m=new HashMap<String,Object>();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("password", u.getPassword());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());
		
		KeyHolder kh=new GeneratedKeyHolder();
		SqlParameterSource p= new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql, p,kh);
		System.out.println("User Created");
		}
		catch(Exception ex) {
			System.out.println("Exception."+ex.getMessage());
		}
		
	}



}
