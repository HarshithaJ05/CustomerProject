package com.customer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.daoIml.CustomerDaoIml;
import com.customer.module.Customer;

@WebServlet("/SearchCustomerServlet")
public class SearchCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String searchBy = request.getParameter("searchBy");
		String searchText = request.getParameter("searchText").trim();
		CustomerDaoIml customerDaoIml = new CustomerDaoIml();
		List<Customer> resultSet=null;

		if (searchBy.equals("firstName")) {
			 resultSet = customerDaoIml.getCustomerByFirstName(searchText);
	}
		else if(searchBy.equals("city")) {
			resultSet=customerDaoIml.getCustomerByCity(searchText);
		}
		else if(searchBy.equals("email")) {
			resultSet=customerDaoIml.getCustomerByEmail(searchText);
		}
		else if(searchBy.equals("phoneNumber")) {
			resultSet=customerDaoIml.getCustomerByPhone(searchText);
		}
	   
		if (resultSet != null && !resultSet.isEmpty()) {
            request.setAttribute("resultSet", resultSet);
            request.getRequestDispatcher("search_results.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "No results found for the search criteria.");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
		
		
	}

}
