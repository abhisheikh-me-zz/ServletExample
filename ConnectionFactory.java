package com.nucleus.connection;

public class ConnectionFactory {


	static ConnectionI getConnectionMethod(String str) 
	 { 
	 	if(str.equalsIgnoreCase("mysql")) 
	 	{ 
	 		return new MysqlConnection(); 
	 	} 
	 	else 
	 	{ 
			return new OracleConnection(); 
	 	} 
	 } 

}
