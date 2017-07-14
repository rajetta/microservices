package com.oracle.acs.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.acs.model.Echo;

/**
 * This class demonstrates the ways to access configuration properties from configuration server
 * @author anvarana
 *
 */

@RestController
@RefreshScope
public class MessageController {
	
	@Value("${database.url}")
	private String uri;
	@Value("${database.username}")
	private String userName;
	
	@Value("${database.connections}")
	private int number;
	@Value("${retrycount}")
	private int retrycount;
	
	@Value("${database.password}")
	private String password;
	
	

	@RequestMapping("/echo")
	public Echo getMessage() {
		StringBuilder builder = new StringBuilder();
		Echo echo = new Echo();
		echo.setConnections(number);
		echo.setUrl(uri);
		echo.setUserName(userName);
		echo.setRetrycount(retrycount);
		echo.setPassword(password);
		
		return echo;
		
		
		/*builder.append("Hi there! This is Echo Service ");
		builder.append(System.lineSeparator());
		builder.append("Database URL "+uri);
		builder.append(System.lineSeparator());
		builder.append("User Name "+userName);
		builder.append(System.lineSeparator());
		builder.append("Max connection allowed "+number);
		builder.append(System.lineSeparator());
		builder.append("retrycount "+retrycount);
		
		return builder.toString();*/
	}
}
