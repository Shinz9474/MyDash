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
import com.MKBot.dao.MKBotLocatorTypeDao;
import com.MKBot.domain.MKBotLocatorType;
import com.MKBot.rm.MKBotLocatorTypeRm;
import com.MKBot.util.MKBotDateUtil;

@Repository
public class MKBotLocatorTypeDaoImpl extends BaseDAO implements MKBotLocatorTypeDao {

	@Override
	public int createLocatorType(MKBotLocatorType locatorType) throws ParseException {

		String sql = "insert into mkbot.mkbot_locator_type(TYPE_NAME,CREATED_BY,CREATEDDATE,MODIFIEDBY,MODIFIEDDATE)"
				+ " values(:typeName,:createdBy,:createdDate,:modifiedBy,:modifiedDate)";

		Map<String, Object> m = new HashMap<String, Object>();
		// m.put("Locator_Type_id", locatorType.getLocatorTypeID());
		m.put("typeName", locatorType.getTypeName());
		m.put("createdBy", locatorType.getCreatedBy());
		m.put("createdDate", MKBotDateUtil.getCurrentDate());
		m.put("modifiedBy", locatorType.getModifiedBy());
		m.put("modifiedDate", MKBotDateUtil.getCurrentDate());

		KeyHolder kh = new GeneratedKeyHolder();

		SqlParameterSource sp = new MapSqlParameterSource(m);
		int count = super.getNamedParameterJdbcTemplate().update(sql, sp, kh);

		Integer locatorTypeID = kh.getKey().intValue();
		locatorType.setLocatorTypeID(locatorTypeID);

		return count;
	}

	@Override
	public List<MKBotLocatorType> getAllLocatorTypes() {

		String sql_get = "select * from mkbot.mkbot_locator_type";
		return super.getJdbcTemplate().query(sql_get, new MKBotLocatorTypeRm());
	}

	@Override
	public int updateLocatorType(MKBotLocatorType locatorType) throws ParseException {
		String sql = "update mkbot.mkbot_locator_type set TYPE_NAME = :typeName ,MODIFIEDBY= :modifiedBy , "+
	"MODIFIEDDATE = :modifiedDate  where LOCATOR_TYPE_ID="+locatorType.getLocatorTypeID();

		Map<String, Object> m = new HashMap<String, Object>();
		// m.put("Locator_Type_id", locatorType.getLocatorTypeID());
		m.put("typeName", locatorType.getTypeName());
		m.put("modifiedBy", locatorType.getModifiedBy());
		m.put("modifiedDate", MKBotDateUtil.getCurrentDate());

		KeyHolder kh = new GeneratedKeyHolder();

		SqlParameterSource sp = new MapSqlParameterSource(m);
		int count = super.getNamedParameterJdbcTemplate().update(sql, sp, kh);

		return count;
	}

	@Override
	public int deleteLocatorType(MKBotLocatorType locatorType) {
		String sql_del="delete from mkbot.mkbot_locator_type where locator_Type_Id="+locatorType.getLocatorTypeID();
		 Map<String,Object> m=new HashMap<String,Object>();
			
	       KeyHolder kh=new GeneratedKeyHolder();	
	       SqlParameterSource sp=new MapSqlParameterSource(m);
	       int count=super.getNamedParameterJdbcTemplate().update(sql_del, sp,kh);		
	       return count;    
	}

	@Override
	public List<MKBotLocatorType> getInsertedLoactorType() {

		String sql_inserted = "select * from mkbot.mkbot_locator_type order by LOCATOR_TYPE_ID desc limit 1";
		return super.getJdbcTemplate().query(sql_inserted, new MKBotLocatorTypeRm());
	}

}
