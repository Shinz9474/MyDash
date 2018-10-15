package com.MKBot.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.MKBot.dao.BaseDAO;
import com.MKBot.dao.MKBotProjectCRUDDao;
import com.MKBot.domain.MKBotProjectCRUD;
import com.MKBot.domain.MKBotProjectDetails;
import com.MKBot.util.MKBotDateUtil;

@Repository
public class MKBotProjectCRUDDaoImpl extends BaseDAO implements  MKBotProjectCRUDDao{

	@Override
	public int saveProject(MKBotProjectCRUD pCRUD) {
		
		if(pCRUD.getInsertProjects().size()>0)
		insertProject(pCRUD.getInsertProjects());
		
		if(pCRUD.getDelProjects().size()>0)
			deleteProjects(pCRUD.getDelProjects());
		
		if(pCRUD.getUpdateProjects().size()>0)
			updateProjects(pCRUD.getUpdateProjects());
		
		return 0;
	}
	
	private  void  insertProject(List<MKBotProjectDetails> insertProjects) {
		String sql="insert into MKBotProject(ProjectName,ProjectDescription,CreatedBy,CreatedDate,ModifiedDate,ModifiedBy,isactive)"
				+ " values(?,?,?,?,?,?,?)";

		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

	        @Override
	        public void setValues(PreparedStatement ps, int i)
	            throws SQLException {

	        	MKBotProjectDetails project= insertProjects.get(i);
	        	ps.setString(1, project.getProjectName());
	        	ps.setString(2, project.getProjectDescription());
	        	ps.setString(3, project.getCreatedBy());
	        	try {
					ps.setString(4, MKBotDateUtil.getCurrentDate().toString());
					ps.setString(5, MKBotDateUtil.getCurrentDate().toString());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	ps.setString(6, project.getModifiedBy());
	        	ps.setInt(7, project.getIsActive());
	        	
	           

	        }

	        @Override
	        public int getBatchSize() {
	            return insertProjects.size();
	        }
	    });
		
		
	}
	
	private void deleteProjects(List<MKBotProjectDetails> delProjects) {
		
		String sql="delete from mkbotproject where projectid=?";
		
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

	        @Override
	        public void setValues(PreparedStatement ps, int i)
	            throws SQLException {

	        	MKBotProjectDetails project= delProjects.get(i);
	        	ps.setInt(1, project.getProjectId());
	        }

	        @Override
	        public int getBatchSize() {
	            return delProjects.size();
	        }
	    });
		
	}
	
	private void updateProjects(List<MKBotProjectDetails> updateProjects) {
		
		String sql="update mkbotproject set ProjectName=?, ProjectDescription=?, ModifiedBy=?,ModifiedDate=?,isactive=?"
				+ " where projectid=?";
		
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

	        @Override
	        public void setValues(PreparedStatement ps, int i)
	            throws SQLException {

	        	MKBotProjectDetails project= updateProjects.get(i);
	        	ps.setString(1, project.getProjectName());
	        	ps.setString(2, project.getProjectDescription());
	        	ps.setString(3, project.getModifiedBy());
	        	try {
					ps.setString(4, MKBotDateUtil.getCurrentDate().toString());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	ps.setInt(5, project.getIsActive());
	        	
	        	ps.setInt(6, project.getProjectId());
	        	
	           

	        }

	        @Override
	        public int getBatchSize() {
	            return updateProjects.size();
	        }
	    });
		
	}

	
	
	
}
