package com.MKBot.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.MKBot.domain.MKBotActionKeywords;

public class MKBotActionKeysRm implements RowMapper<MKBotActionKeywords> {

	@Override
	public MKBotActionKeywords mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MKBotActionKeywords actionKey=new MKBotActionKeywords();
		
		
		return null;
	}

}
