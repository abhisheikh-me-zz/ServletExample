package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.Entity.CustomerPojo;
import com.nucleus.Service.CustomerService;
import com.nucleus.Service.CustomerServiceI;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String action = request.getParameter("action");
		try
		{
		 if(action.equals("home"))
		 {
			 	if(session!=null)
			 	{
			 				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			 				rd.include(request, response);
			 	}
		
			 	else 
			 	{
			 				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			 				rd.include(request, response);
			 	}
		 }
		 
		  if(action.equals("menu"))
		 { 
				if(session!=null)
				{
					
							RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
							rd.include(request, response);
				}
				
				else
				{
							RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
							rd.include(request, response);
				}
		 }
		  if(action.equals("NewCustomer"))
		 {
				if(session!=null)
				{
							RequestDispatcher rd = request.getRequestDispatcher("NewCustomer.jsp");
							rd.include(request, response);
				}
				
				else
				{
							RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
							rd.include(request, response);
				}
		 }
		 
		 if(action.equals("View"))
		 {
		if(session!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
			rd.include(request, response);
		}
		
		else{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		 }
		 if(action.equals("SingleView"))
		 {
		if(session!=null)
		{

			RequestDispatcher rd = request.getRequestDispatcher("SingleView.jsp");
			rd.include(request, response);
			}
		
		else{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		}
		 
		 if(action.equals("MultipleView")){
		 
		if(session!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("ViewDetails.jsp");
			rd.include(request, response);
			}
		
		else{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
	
		 }
		 if(action.equals("delete")){
		if(session!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			rd.include(request, response);
			}
		
		else{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		 }
		
		 
		 if(action.equals("update")){
				if(session!=null)
				{
					RequestDispatcher rd = request.getRequestDispatcher("Entercode.jsp");
					rd.include(request, response);
					}
				
				else{
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
				}
				 }
		 if(action.equals("logout")){
			 if(session!=null){
				 session.invalidate();
				 
			 }
			 RequestDispatcher rd = request.getRequestDispatcher("Logout.jsp");
				rd.include(request, response);
		 }
		}
		catch (Exception ex ){
			RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
			rd.include(request, response);
			
		}
	}
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try
		{
		HttpSession session=request.getSession(false);
		CustomerServiceI s = new CustomerService();
		CustomerPojo c  = new CustomerPojo();
		if(action.equals("singleView"))
		{
			if(session!=null)
		 	{
						String code = request.getParameter("code");
						 if(s.exist(code))
						 {
						
								ArrayList<CustomerPojo> customer = s.singleView(code);
								
								request.setAttribute("customer" ,customer);
								RequestDispatcher rd = request.getRequestDispatcher("ViewDetails.jsp");
								rd.include(request, response);
						 }
						 else
						 {
							 RequestDispatcher rd = request.getRequestDispatcher("RecordNotFound.jsp");
								rd.include(request, response); 
						 }
		 	}
			 else
			 {
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
			}
		}
		if(action.equals("viewAll"))
		{
			if(session!=null)
		 	{
			ArrayList<CustomerPojo> customer=s.viewAll();
			request.setAttribute("customer", customer);
			RequestDispatcher rd=request.getRequestDispatcher("ViewDetails.jsp");
			rd.forward(request, response);
		}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}
		}
			
		if(action.equals("delete"))
		{

					if(session!=null)
				 	{
							 String code=request.getParameter("code");
							 	if(s.exist(code))
							 	{
											c.setCustomerCode(code);
										    boolean u= s.deleteCus(c); 
										    RequestDispatcher rd=request.getRequestDispatcher("RecordDeleted.jsp");
										    rd.forward(request, response);
						     	}
								else
								{
									 RequestDispatcher rd=request.getRequestDispatcher("RecordNotFound.jsp");
									  rd.forward(request, response); 
								}
					}
					else
					{
							RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
							rd.include(request, response);
					}
		}
		if(action.equals("insert"))
		{

			if(session!=null)
		 	{
			
			String name=request.getParameter("name");
			String code=request.getParameter("code");
			System.out.println(code);
			String address1=request.getParameter("Address1");
			String address2=request.getParameter("Address2");
			String pincode=request.getParameter("Pincode");
			String email=request.getParameter("E_mailAddress");
			String number=request.getParameter("ContactNumber");
			String primaryContact=request.getParameter("PrimaryContactPerson");
			
			
			c.setCustomerCode(code);
			c.setCustomerName(name);
			c.setCustomerAddress1(address1);
			c.setCustomerAddress2(address2);
			c.setCustomerPinCode((pincode));
			c.setEmailaddress(email);
			c.setContactNumber((number));
			c.setPrimaryContactPerson(primaryContact);
			c.setRecordStatus("N");
			c.setActiveInactiveFlag("A");
			c.setCreatedBy("Abhi");
			c.setCreateDate();
			boolean u=s.insertRecord(c);
			RequestDispatcher rd=request.getRequestDispatcher("RecordInserted.jsp");
			
			rd.forward(request, response);
			
		 	}
			else
			{
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
			}
		
		}
		 if(action.equals("update"))
		 {
			 if(session!=null)
			 	{
				String code=request.getParameter("code");
				 if(s.exist(code)){
                	  
                  
				ArrayList<CustomerPojo> customer = s.singleView(code);
				
				request.setAttribute("customer" ,customer);
				RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
				rd.include(request, response);
                  }
                  else
                  {
                	  
                	  RequestDispatcher rd = request.getRequestDispatcher("RecordNotFound.jsp");
      				rd.include(request, response);  
                  }
				 
				}
				else
				{
						RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
						rd.include(request, response);
				} 
				 
		 }
			if(action.equals("ViewByChoice"))
			{
		
				
				if(session!=null)
			 	{
					String Date=request.getParameter("Date");
					String flag=request.getParameter("Flag");
							 if(s.exist(Date,flag))
							 {
							
									ArrayList<CustomerPojo> customer = s.exists(Date, flag);
									
									request.setAttribute("customer" ,customer);
									RequestDispatcher rd = request.getRequestDispatcher("ViewDetails.jsp");
									rd.include(request, response);
							 }
							 else
							 {
								 RequestDispatcher rd = request.getRequestDispatcher("RecordNotFound.jsp");
									rd.include(request, response); 
							 }
			 	}
				 else
				 {
						RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
						rd.include(request, response);
				}	
				
				
				
			}
		 
		 if(action.equals("updateDetail"))
		 {
			 if(session!=null)
			 	{
		
			 String name=request.getParameter("name");
				String code=request.getParameter("code");
				System.out.println("drg"+code);
				String address1=request.getParameter("Address1");
				String address2=request.getParameter("Address2");
				String pincode=request.getParameter("Pincode");
				String email=request.getParameter("E_mailAddress");
				String number=request.getParameter("Contactnumber");
				String primaryContact=request.getParameter("PrimaryContactPerson");
				
				c.setCustomerCode(code);
				c.setCustomerName(name);
				c.setCustomerAddress1(address1);
				c.setCustomerAddress2(address2);
				c.setCustomerPinCode((pincode));
				c.setEmailaddress(email);
				c.setContactNumber((number));
				c.setPrimaryContactPerson(primaryContact);
				c.setRecordStatus("N");
				c.setActiveInactiveFlag("A");
				c.setCreatedBy("Abhi");
				c.setCreateDate();
				boolean u=s.update(c);
				System.out.println(u);
				
				RequestDispatcher rd=request.getRequestDispatcher("RecordUpdated.jsp");
				
				rd.forward(request, response); 
				}
				else
				{
						RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
						rd.include(request, response);
				} 
				 
	}
	}
		catch(Exception ex){
			RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
			rd.include(request, response);
		}
		

		
}
	
	}
