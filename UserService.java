package com.nucleus.Service;

import com.nucleus.UserDao.UserDao;
import com.nucleus.UserDao.UserDaoI;


public class UserService implements UserServiceI{
	
	UserDaoI dao =  new UserDao();

	public boolean login(String user ,String pass)
	 {

		boolean a = dao.login(user, pass);
		if(a)
		return true;
		return false;
	 }

	
	public String getRole(String user) {
		
		
		String a = dao.getRole(user);
		
		
		return a;
	}





	
}
