package com.nucleus.UserDao;

public interface UserDaoI {
	
	public boolean login(String u ,String p);
	
	String getRole(String user);

}
