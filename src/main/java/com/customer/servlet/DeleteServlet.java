package com.customer.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.daoIml.CustomerDaoIml;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		String customerId = request.getParameter("customerId")    ;
			  CustomerDaoIml cuImpl = new CustomerDaoIml();
			  cuImpl.deleteCustomer(customerId);
			  request.getRequestDispatcher("home.jsp").include(request, response);;
			  
	}

}
