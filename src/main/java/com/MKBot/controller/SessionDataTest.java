package com.MKBot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class SessionDataTest {
	 @Autowired
	  private WebApplicationContext appContext;

	  public void storeAndRetrieveSomethingInAppScope(String name, Object object) {
	     appContext.getServletContext().setAttribute(name,object);
	     //Object fromAppContext = appContext.getServletContext().getAttribute(name);
	  }

}
