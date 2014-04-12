package com.cometpark.server.model;

public class UserObject {
	private String userName ;
	private String password ;
	private String email;
	private String permitType;
	
	public String getUserName (){
		return this.userName;
	}
	public void setUserName (String userName){
		this.userName = userName;
	}
	
	public String getPassword (){
		return this.password;
	}
	public void setPassword (String pass){
		this.password = pass;
	}
	
	public String getEmail (){
		return this.email;
	}
	public void setEmail (String email){
		this.email = email;
	}
	
	public String getPermitType (){
		return this.permitType;
	}
	public void setPermitType (String permitType){
		this.permitType = permitType ;
	}
}
