package com.nucleus.CustomerDao;

import java.util.ArrayList;
import java.util.List;

import com.nucleus.Entity.CustomerPojo;

public interface CustomerDaoI {
	
	
	
	public ArrayList<CustomerPojo>  singleView(String code);

	public ArrayList<CustomerPojo> viewAll();
	
	public boolean deleteCus(CustomerPojo c);
	
	public boolean insertRecord(CustomerPojo  c);
	
	public boolean update(CustomerPojo c);
	
	public boolean exist(String code);
	public boolean exist(String Flag,String Date);

	public ArrayList<CustomerPojo> exists(String date, String flag);
}
