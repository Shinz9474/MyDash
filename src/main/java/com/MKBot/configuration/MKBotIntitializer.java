package com.MKBot.configuration;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class MKBotIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { MKBotRootConfig.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
    	return new Class[] { MKBotConfiguration.class };
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    @Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new CORSFilter() };
    	return singleton;
	}
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	super.onStartup(servletContext);
    	//Configure global task here
    }
 
}