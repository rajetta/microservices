package com.oracle.acs.model;

public class Echo {
	
	private String userName;
	private String password;
	private int connections;
	private int retrycount;
	private String url;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getConnections() {
		return connections;
	}
	public void setConnections(int connections) {
		this.connections = connections;
	}
	public int getRetrycount() {
		return retrycount;
	}
	public void setRetrycount(int retrycount) {
		this.retrycount = retrycount;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
