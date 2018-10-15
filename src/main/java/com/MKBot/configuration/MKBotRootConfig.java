package com.MKBot.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = { "com.MKBot" }, excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = Configuration.class) })


public class MKBotRootConfig {

	//TODO: Services, Datasources, DAO, Email Sender and other some business layer beans
	
	@Bean
	public BasicDataSource getDataSource() {
		
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://10.4.64.106:3306/mkbot");
		ds.setUsername("root");
		ds.setPassword("root");
		//ds.setMaxTotal(10);
//		ds.setInitialSize(1);
//		ds.setTestOnBorrow(true);
//		ds.setValidationQuery("SELECT 1");
		ds.setDefaultAutoCommit(true);
		
		return ds;
	
	}
}
