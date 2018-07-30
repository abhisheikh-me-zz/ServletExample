package com.nucleus.CustomerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.nucleus.Entity.CustomerPojo;
import com.nucleus.connection.ConnectionI;
import com.nucleus.connection.OracleConnection;

public class CustomerDao implements CustomerDaoI{
	Statement stmt=null;
	Connection conn  = null;
	ConnectionI c1 = null;
	PreparedStatement pst = null ;
	ResultSet rs = null;
	public ArrayList<CustomerPojo>  singleView( String code)
	{
		 		
		ArrayList <CustomerPojo> customer= new ArrayList<CustomerPojo>();	
		try {

		 c1=new  OracleConnection();
		 conn=c1.myConnection();
		 String str = "select * from CustomerMasterNsbt089 where CustomerCode='"+code+"'";
		pst=conn.prepareStatement(str);
		 rs = pst.executeQuery();
			 while(rs.next())	
			 {
				 CustomerPojo c=new CustomerPojo();
				 c.setCustomerCode(rs.getString(2));
				 c.setCustomerName(rs.getString(3));
				 c.setCustomerAddress1(rs.getString(4));
				 c.setCustomerAddress2(rs.getString(5));
				 c.setCustomerPinCode(rs.getString(6));
				 c.setEmailaddress(rs.getString(7));
				 c.setContactNumber(rs.getString(8));
				 c.setPrimaryContactPerson(rs.getString(9));
				 c.setRecordStatus(rs.getString(10));
				 c.setActiveInactiveFlag(rs.getString(11));
				 c.setCreateDate();
			     c.setCreatedBy(rs.getString(13));
			     c.setModifiedDate();
			     c.setModifiedBy(rs.getString(15));
			     c.setAuthorizedBy(rs.getString(16));
			     c.setAuthorizedDate();
				 customer.add(c);	
			 }
		 }
		 catch(SQLException e){
			 
		 }
		return customer;
	}
	@Override
	public ArrayList<CustomerPojo> viewAll() {
	
		ArrayList <CustomerPojo> customer= new ArrayList<CustomerPojo>();	
		
		try {

			 c1=new  OracleConnection();
			 conn=c1.myConnection();
			 String str = "select * from CustomerMasterNsbt089";
			pst=conn.prepareStatement(str);
			 rs = pst.executeQuery();
				 while(rs.next())	
				 {
					 CustomerPojo c=new CustomerPojo();
					 c.setCustomerCode(rs.getString(2));
					 c.setCustomerName(rs.getString(3));
					 c.setCustomerAddress1(rs.getString(4));
					 c.setCustomerAddress2(rs.getString(5));
					 c.setCustomerPinCode(rs.getString(6));
					 c.setEmailaddress(rs.getString(7));
					 c.setContactNumber(rs.getString(8));
					 c.setPrimaryContactPerson(rs.getString(9));
					 c.setRecordStatus(rs.getString(10));
					 c.setActiveInactiveFlag(rs.getString(11));
					 c.setCreateDate();
				     c.setCreatedBy(rs.getString(13));
				     c.setModifiedDate();
				     c.setModifiedBy(rs.getString(15));
				     c.setAuthorizedBy(rs.getString(16));
				     c.setAuthorizedDate();
					 customer.add(c);	
				 }
			 }
			 catch(SQLException e){
				 
			 }
			return customer;
	}
	
	public boolean deleteCus(CustomerPojo c) {
		
		
		int u = 0;
		 try {
		 c1=new  OracleConnection();
		 conn=c1.myConnection();
		String str="DELETE FROM CustomerMasterNsbt089 WHERE CUSTOMERCODE='"+c.getCustomerCode()+"'";
		pst=conn.prepareStatement(str);
		 u = pst.executeUpdate();
		 
		 if(u>0)
			 
		 {
			return true; 
		 }
			
		 else{
			 return false;
		 }
		 }
		catch(SQLException ex){
			ex.printStackTrace();
			return false;
		}
		
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public boolean insertRecord(CustomerPojo  c)
	{
		int j = 0;
		try
		{
			if(conn==null)
			{
			c1 = new OracleConnection();
			conn = c1.myConnection();
			}
			
			String str="insert into CustomerMasterNsbt089 values(CustomerMasterNsbt089_sq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		pst = conn.prepareStatement(str);	
	    pst.setString(1,c.getCustomerCode());
		pst.setString(2,c.getCustomerName());
		pst.setString(3,c.getCustomerAddress1());
		pst.setString(4,c.getCustomerAddress2());
		pst.setString(5,c.getCustomerPinCode());
		pst.setString(6,c.getEmailaddress());
		pst.setString(7,c.getContactNumber());
		pst.setString(8,c.getPrimaryContactPerson());
		pst.setString(9,c.getRecordStatus());
		pst.setString(10,c.getActiveInactiveFlag());
		Date date = new Date();
		pst.setDate(11, new java.sql.Date(date.getTime()));
		pst.setString(12,c.getCreatedBy());
		pst.setDate(13, new java.sql.Date(date.getTime()));
		pst.setString(14,c.getModifiedBy());
		pst.setDate(15, new java.sql.Date(date.getTime()));
		pst.setString(16,c.getAuthorizedBy());
		j=pst.executeUpdate();
		
		if(j>0){
			return true;
			
		}
		else{
			return false;
		}
		}
		catch(SQLException ex)
		{

			System.out.println("Record Already Exist in Database");
	      ex.printStackTrace();
	      return false;
		}

		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
    public boolean update(CustomerPojo c) {
		
		
		int u = 0;
		 try {
		 c1=new  OracleConnection();
		 conn=c1.myConnection();
	   	String str="Update  CustomerMasterNsbt089 set Customername=?, CustomerAddress1=?, CustomerAddress2=?,CUSTOMERPINCODE=?,E_MAILADDRESS=?,CONTACTNUMBER=?,PRIMARYCONTACTPERSON=?,RECORDSTATUS=?,ACTIVE_INACTIVEFLAG=?,CREATEDBY=? Where CUSTOMERCODE=?";
		   pst=conn.prepareStatement(str);
		   pst.setString(1,c.getCustomerName());
			pst.setString(2,c.getCustomerAddress1());
			pst.setString(3,c.getCustomerAddress2());
			pst.setString(4,c.getCustomerPinCode());
			pst.setString(5,c.getEmailaddress());
			pst.setString(6,c.getContactNumber());
			pst.setString(7,c.getPrimaryContactPerson());
			pst.setString(8,c.getRecordStatus());
			pst.setString(9,c.getActiveInactiveFlag());
			pst.setString(10,c.getCreatedBy());
			pst.setString(11,c.getCustomerCode());
			 u = pst.executeUpdate();
			 System.out.println("daoo" +u);
			 
			 
		  if(u>0)
			 
		 {
			return true; 
		 }
			
		 else{
			 return false;
		 }
		 }
		catch(SQLException ex){
			ex.printStackTrace();
			return false;
		}
		 finally{
			 try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
	
	
    }
	

 public boolean exist( String code ){
    	
    	int j = 0;
		try
		{
		
			c1 = new OracleConnection();
			conn = c1.myConnection();
			
			
			String str="Select * from CustomerMasterNsbt089 where CustomerCode=?";
		
			  pst=conn.prepareStatement(str);
			  pst.setString(1, code);
    	
    	      rs=pst.executeQuery();
    	      
    	      while(rs.next())
    	      {
    	    	  j++;
    	    	  
    	      }
    	      
    	        if(j!=0)
    	        {
    	        return true;	
    	        }
    	return false;

    }
    
		
		catch(SQLException ex){
			ex.printStackTrace();
			return false;
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }    
 public boolean exist( String Date,String Flag ){
    	
    	int j = 0;
		try
		{
		
			c1 = new OracleConnection();
			conn = c1.myConnection();
			
		System.out.println(Date + Flag);
			String str="Select * from CustomerMasterNsbt089 where CREATDATE =? and ACTIVE_INACTIVEFLAG=?";
		
			  pst=conn.prepareStatement(str);
			  pst.setString(1, Date);
			  pst.setString(2, Flag);
    	
    	      rs=pst.executeQuery();
    	      
    	      while(rs.next())
    	      {
    	    	  j++;
    	    	  
    	      }
    	        if(j!=0)
    	        {
    	        return true;	
    	        }
    	return false;

    }
    
		
		catch(SQLException ex){
			ex.printStackTrace();
			return false;
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }

	public ArrayList<CustomerPojo> exists(String date, String flag) {
		ArrayList<CustomerPojo> customer = new ArrayList<CustomerPojo>();

		try {
			c1 = new OracleConnection();
			conn = c1.myConnection();
			String str = "select * from CustomerMasterNsbt089 where CREATDATE=? and ACTIVE_INACTIVEFLAG=?";
			  pst=conn.prepareStatement(str);
			  pst.setString(1, date);
			  pst.setString(2, flag);
    	
    	      rs=pst.executeQuery();
    	      
			while (rs.next()) {
				CustomerPojo c = new CustomerPojo();
				c.setCustomerCode(rs.getString(2));
				c.setCustomerName(rs.getString(3));
				c.setCustomerAddress1(rs.getString(4));
				c.setCustomerAddress2(rs.getString(5));
				c.setCustomerPinCode(rs.getString(6));
				c.setEmailaddress(rs.getString(7));
				c.setContactNumber(rs.getString(8));
				c.setPrimaryContactPerson(rs.getString(9));
				c.setRecordStatus(rs.getString(10));
				c.setActiveInactiveFlag(rs.getString(11));
				c.setCreateDate();
				c.setCreatedBy(rs.getString(13));
				c.setModifiedDate();
				c.setModifiedBy(rs.getString(15));
				c.setAuthorizedBy(rs.getString(16));
				c.setAuthorizedDate();
				customer.add(c);
				System.out.println();
			}
			return customer;
		} catch (SQLException e) {

		}
		return customer;
	}

}
