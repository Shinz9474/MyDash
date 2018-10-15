package com.MKBot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MKBotActionKeywords {
	
	private Integer ActionId;
	private String ActionKeywordName;
	private String ActionDescription;
	private String isActive;
	private String createdBy;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private String createdDate;
	private String modifiedBy;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private String modifiedDate;
	
	public Integer getActionId() {
		return ActionId;
	}
	public void setActionId(Integer actionId) {
		ActionId = actionId;
	}
	public String getActionKeywordName() {
		return ActionKeywordName;
	}
	public void setActionKeywordName(String actionKeywordName) {
		ActionKeywordName = actionKeywordName;
	}
	public String getActionDescription() {
		return ActionDescription;
	}
	public void setActionDescription(String actionDescription) {
		ActionDescription = actionDescription;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
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
