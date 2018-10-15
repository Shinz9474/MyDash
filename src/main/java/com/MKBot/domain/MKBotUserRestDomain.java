package com.MKBot.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class MKBotUserRestDomain {
	
	private MKBotUser user;
	
	private MKBotErrorClass error;

	public MKBotUser getUser() {
		return user;
	}

	public void setUser(MKBotUser user) {
		this.user = user;
	}

	public MKBotErrorClass getError() {
		return error;
	}

	public void setError(MKBotErrorClass error) {
		this.error = error;
	}
	
	private String Message;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	

}
