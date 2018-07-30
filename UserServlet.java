package com.nucleus.controller;

 import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.Service.UserService;
import com.nucleus.Service.UserServiceI;
 @WebServlet("/UserServlet")
 public class UserServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String action = request.getParameter("action");
		try{
			
		if(session!=null)
		{
			if(action.equals("logout")){
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("Logout.jsp");
			rd.include(request, response);
			}
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
	}
		catch(Exception e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
			rd.include(request, response);
		}
		
	}
 
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession(false);
		  response.setContentType("text/html");  
		  PrintWriter out = response.getWriter();  
		  try{

		 String name=(String) request.getAttribute("user");
		 String pass=(String) request.getAttribute("pass");
		 UserServiceI s=new UserService();
		 boolean a=s.login(name, pass);
         if(a)
         {
         String role=s.getRole(name);
          httpSession = request.getSession();
			if (s.getRole(name).equals("maker"))
				request.getRequestDispatcher(
						"menu.jsp").forward(request,
         			response);
         }               
           else {
        	 request.setAttribute("errorMsg", "Login failed!");
				request.getRequestDispatcher("Invalid.jsp")
						.forward(request, response);
		
	}
	}
		  catch(Exception e)
		  {
			  RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
				rd.include(request, response);
		  }
}
}