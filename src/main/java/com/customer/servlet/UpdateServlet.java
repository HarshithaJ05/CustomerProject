package com.customer.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.daoIml.CustomerDaoIml;
import com.customer.module.Customer;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String uuid = request.getParameter("customerId");
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String street = request.getParameter("street");
	        String address = request.getParameter("address");
	        String city = request.getParameter("city");
	        String state = request.getParameter("state");
	        String email = request.getParameter("email");
	        String phoneNumber = request.getParameter("phoneNumber");
	        
	        
	        Customer customer = new Customer(uuid, firstName, lastName, street, address, city,state, email, phoneNumber);
	        
	        
	        CustomerDaoIml customerDaoIml = new CustomerDaoIml();
	        customerDaoIml.updateCustomer(customer);
	        
	        request.getRequestDispatcher("home.jsp").include(request, response);
	
	}

}
