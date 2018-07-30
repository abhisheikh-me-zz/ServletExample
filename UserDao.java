package com.nucleus.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nucleus.connection.ConnectionI;
import com.nucleus.connection.OracleConnection;

public class UserDao implements UserDaoI{

	Connection conn  = null;
	ConnectionI c1 = null;
	PreparedStatement pst = null ;
	ResultSet rs = null;
	
	public boolean login(String u,String p )
	{
		try
		{
			if(conn==null)

			c1 = new OracleConnection();
			conn = c1.myConnection();
			String username=null;
			String password=null;
			
			Statement statement=null;
			int count = 0 ;
		 conn.setAutoCommit(false);
		String str = "select * from user089 where username  = '"+u+"'";
	    statement = conn.createStatement();	
        rs = statement.executeQuery(str);
        

       while(rs.next())
     {
    	 username=rs.getString(1);
    	 password=rs.getString(2);
     }
       if(u.equals(username)&&p.equals(password))
       {
    	 count++;
     }  	
       

     if(count>0) return true ;
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
			  return false;
		}
	
		return false;


	}
	
	public String getRole(String user)
	{
		String username=null;
		c1=new OracleConnection();
		conn=c1.myConnection();
		
		String str="Select role089.rolename from user089 INNER JOIN role089 ON user089.roleid=role089.roleid where user089.username=?";
		try
		{
		pst=conn.prepareStatement(str);
		pst.setString(1, user);
		rs=pst.executeQuery();
		while(rs.next())
		{
		username=rs.getString(1);
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return username;
	}

	
	}


	
	
	
	
	
	
	


