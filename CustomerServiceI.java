package com.nucleus.Service;

import java.util.ArrayList;

import com.nucleus.Entity.CustomerPojo;

public interface CustomerServiceI {

	 public ArrayList<CustomerPojo> singleView(String code);
	public ArrayList<CustomerPojo> viewAll();
	public boolean deleteCus(CustomerPojo c);
	
	public boolean insertRecord(CustomerPojo  c);
	
	public boolean update(CustomerPojo  c);
	public boolean exist(String code);
	public boolean exist(String Date,String Flag);
	public ArrayList<CustomerPojo> exists(String date, String flag);
}
