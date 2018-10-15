package com.MKBot.domain;

public class MKBotErrorClass {
	
	private String ErrorMessage;
	
	private String SysErrorMessage;
	
	private String stackTrace;

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public String getSysErrorMessage() {
		return SysErrorMessage;
	}

	public void setSysErrorMessage(String sysErrorMessage) {
		SysErrorMessage = sysErrorMessage;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	
	

}
