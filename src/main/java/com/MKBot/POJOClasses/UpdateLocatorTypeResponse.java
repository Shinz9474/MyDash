package com.MKBot.POJOClasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateLocatorTypeResponse {

	private String processingMessages;

	@JsonProperty("processingMessages")
	public String getProcessingMessage() {
		return processingMessages;
	}

	@JsonProperty("processingMessages")
	public void setProcessingMessage(String value) {
		this.processingMessages = value;
	}

}
