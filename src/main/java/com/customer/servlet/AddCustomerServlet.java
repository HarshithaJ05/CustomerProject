package com.customer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.daoIml.CustomerDaoIml;
import com.customer.module.Customer;
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String uuid = request.getParameter("uuid");
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String street = request.getParameter("street");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String email = request.getParameter("email");
        String phoneNumberStr = request.getParameter("phoneNumber");
        
//        Customer customer = new Customer(uuid,firstName, lastName, street, address, city,state, email, phoneNumberStr);
      Customer customer=  new Customer(uuid, firstName, lastName, street, address, city, state, email, phoneNumberStr);
        CustomerDaoIml customerDaoIml = new CustomerDaoIml();
        int i = customerDaoIml.addCustomer(customer);
        if(i>0) {
        	request.setAttribute("successfull Message", "Customer added successfully");
        	request.getRequestDispatcher("home.jsp").include(request, response);
        }
        else {
        	request.setAttribute("errorMessage", "Failed to add customer");
        	request.getRequestDispatcher("addCustomer.jsp").include(request, response);;
        	
        }
        
		
		
		
	
	}

}
