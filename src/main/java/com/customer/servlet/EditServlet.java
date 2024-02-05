package com.customer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.daoIml.CustomerDaoIml;
import com.customer.module.Customer;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		
	String customerId = request.getParameter("customerId") ;
	CustomerDaoIml customerDaoIml = new CustomerDaoIml();
	Customer customer = customerDaoIml.getCustomerById(customerId);
	
	 if (customer != null) {
         
         // Forward the request to the edit.jsp page along with the customer object
         request.setAttribute("customer", customer);
         request.getRequestDispatcher("edit.jsp").forward(request, response);
     } else {
         // If customer not found, handle the error or redirect to an error page
         response.getWriter().println("Customer not found");
     }
	
	
	
	
	}
	
	
	
	

	
	
	
}
