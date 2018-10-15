package com.MKBot.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class MKBotProjectRestDomain {
	
	private MKBotProjectDetails project;
	private MKBotErrorClass error;
	private String Message;
	public MKBotProjectDetails getProject() {
		return project;
	}
	public void setProject(MKBotProjectDetails project) {
		this.project = project;
	}
	public MKBotErrorClass getError() {
		return error;
	}
	public void setError(MKBotErrorClass error) {
		this.error = error;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	

}
