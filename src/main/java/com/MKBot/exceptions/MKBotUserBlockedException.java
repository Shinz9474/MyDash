package com.MKBot.exceptions;

public class MKBotUserBlockedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MKBotUserBlockedException() {
		
	}
	public MKBotUserBlockedException(String error) {
		super(error);
	}

}
