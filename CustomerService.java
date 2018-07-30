package com.nucleus.Service;

import java.util.ArrayList;

import com.nucleus.CustomerDao.CustomerDao;
import com.nucleus.CustomerDao.CustomerDaoI;
import com.nucleus.Entity.CustomerPojo;


public class CustomerService implements CustomerServiceI{

	CustomerDaoI dao = new CustomerDao();
	public ArrayList<CustomerPojo> singleView(String code) {
		ArrayList a = dao.singleView(code);
		return a;
	}
	public ArrayList<CustomerPojo> viewAll(){
		ArrayList a = dao.viewAll();
		return a;
		
	}
	public boolean deleteCus(CustomerPojo c) {
		boolean a=dao.deleteCus(c);
		if(a)
			return true;
	        return false;		
	}
	
		
	public boolean insertRecord(CustomerPojo  c){
		boolean a=dao.insertRecord(c);
		if(a)
		return true;
		return false;
		
	}
	
	public boolean update(CustomerPojo  c){
		boolean a=dao.update(c);
		if(a)
		return true;
		return false;
}
	public boolean exist(String code) {
		boolean a=dao.exist(code);
		if(a)
		return true;
       return false;
}
	public boolean exist(String Date,String Flag) {
		boolean a=dao.exist(Date	,Flag);
		if(a)
		return true;
       return false;
}
	public ArrayList<CustomerPojo> exists(String date, String flag) {

			ArrayList<CustomerPojo> a = dao.exists( date,  flag);
			return a;
		
	}

}