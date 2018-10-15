package com.MKBot.domain;

import java.util.List;

public class MKBotProjectCRUD {
	
	private List<MKBotProjectDetails> insertProjects;
	
	private List<MKBotProjectDetails> delProjects;
	
	private List<MKBotProjectDetails> updateProjects;

	public List<MKBotProjectDetails> getInsertProjects() {
		return insertProjects;
	}

	public void setInsertProjects(List<MKBotProjectDetails> insertProjects) {
		this.insertProjects = insertProjects;
	}

	public List<MKBotProjectDetails> getDelProjects() {
		return delProjects;
	}

	public void setDelProjects(List<MKBotProjectDetails> delProjects) {
		this.delProjects = delProjects;
	}

	public List<MKBotProjectDetails> getUpdateProjects() {
		return updateProjects;
	}

	public void setUpdateProjects(List<MKBotProjectDetails> updateProjects) {
		this.updateProjects = updateProjects;
	}

	
	
	

}
