package com.phoenix.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phoenix.exceptions.UserNotFoundException;
import com.phoenix.web.models.LoginBean;

/**
 * Servlet implementation class ValidateServlet
 * @author:raja.kumar@stltech.in
 */
@WebServlet("/LoginS")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String uname=request.getParameter("username");
		  String password=request.getParameter("password");
		  
		  LoginBean obj1=new LoginBean();
		  request.setAttribute("ob", obj1);
		  obj1.setUsername(uname);
		  obj1.setPassword(password);  
		  PrintWriter out=response.getWriter();
		  
		  try {
			if(obj1.isValid())
			  {
				  RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
				  rd.forward(request, response);
			  }
			  else 
			  {
				  out.println("<h3 style='color:red;'>Invalid Login</h3>");
				  RequestDispatcher rd=request.getRequestDispatcher("login.html");
				  rd.include(request, response);
			  }
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
