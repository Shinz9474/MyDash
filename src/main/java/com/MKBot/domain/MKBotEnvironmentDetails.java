package com.MKBot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MKBotEnvironmentDetails {
	

	private Integer isActive;
	private Integer environmentId;
	private String environmentName;
	private String environmentDescription;
	private String createdBy;
	
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private String createdDate;
	private String modifiedBy;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private String modifiedDate;
	public int getenvironmentId() {
		return environmentId;
	}
	public void setenvironmentId(Integer environmentId) {
		this.environmentId = environmentId;
	}
	public String getenvironmentName() {
		return environmentName;
	}
	public void setenvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}
	public String getenvironmentDescription() {
		return environmentDescription;
	}
	public void setenvironmentDescription(String environmentDescription) {
		this.environmentDescription = environmentDescription;
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
