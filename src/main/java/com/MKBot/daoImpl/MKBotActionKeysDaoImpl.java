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
import com.MKBot.dao.MKBotActionKeywordsDao;
import com.MKBot.domain.MKBotActionKeywords;
import com.MKBot.util.MKBotDateUtil;

@Repository
public class MKBotActionKeysDaoImpl extends BaseDAO implements MKBotActionKeywordsDao {

	@Override
	public int createActionKey(MKBotActionKeywords ActionKey) throws ParseException {
		String sql="insert mkbot_action_keywords_repository(action_keyword_name,action_description,created_by,created_date,"
				+ "modified_by,modified_date,isactive) values(:action_keyword_name,:action_description,"
				+ ":created_by,:created_date,:modified_by,:modified_date,:isactive)";
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("action_keyword_name",ActionKey.getActionKeywordName());
		m.put("action_description", ActionKey.getActionDescription());
		m.put("created_by", ActionKey.getCreatedBy());
		m.put("modified_by", ActionKey.getModifiedBy());
		m.put("createdDate", MKBotDateUtil.getCurrentDate());
		m.put("modifiedDate", MKBotDateUtil.getCurrentDate());
		m.put("isactive", ActionKey.getIsActive());	
		KeyHolder kh=new GeneratedKeyHolder();
		SqlParameterSource sp=new MapSqlParameterSource(m);
		int count=super.getNamedParameterJdbcTemplate().update(sql, sp,kh);
		Integer actionId=kh.getKey().intValue();
		ActionKey.setActionId(actionId);
		return count;
	}

	@Override
	public int deleteActionKey(Integer ActionId) {
		
		String sql="delete from mkbot_action_keywords_repository where Action_id= "+ActionId;
		
		return super.getJdbcTemplate().update(sql);
	}

	@Override
	public int updateActionKey(MKBotActionKeywords ActionKey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MKBotActionKeywords> getAllActionKeys() {
		
		return null;
	}

}
