package com.MKBot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MKBotProjectDetails {
	

	private boolean isDeleted;
	private boolean isNew;
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	private Integer isActive;
	private Integer projectId;
	private String projectName;
	private String projectDescription;
	private String createdBy;
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private String createdDate;
	private String modifiedBy;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private String modifiedDate;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {

		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() {

		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		
		this.modifiedDate = modifiedDate;
	}
	
}
