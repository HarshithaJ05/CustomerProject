<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ page import="java.util.List" %>
	<%@ page import="com.customer.daoIml.CustomerDaoIml" %>
	<%@ page import="com.customer.module.Customer,com.customer.module.Admin" %>
	
	
	<%
	    String admin = (String) session.getAttribute("admin"); // Retrieve admin object from session
	
	    if (admin == null) {
	        response.sendRedirect("login.jsp");
	    } else {
	    	 int pageSize = 5; // Number of items per page
	         int currentPage = 1; // Default to the first page

	         // Retrieve page parameter from request if available
	         if (request.getParameter("page") != null) {
	             currentPage = Integer.parseInt(request.getParameter("page"));
	         }
				

	    	    CustomerDaoIml customerDao = new CustomerDaoIml();
	    	    List<Customer>  customers = customerDao.getAllCustomer();
	    	    
	    	    int totalCustomers = customers.size();
	            int totalPages = (int) Math.ceil((double) totalCustomers / pageSize);

	            int startIndex = (currentPage - 1) * pageSize;
	            int endIndex = Math.min(startIndex + pageSize, totalCustomers);
	            List<Customer> currentPageCustomers = customers.subList(startIndex, endIndex);
	        
	%>
	
	
	
	<!DOCTYPE html>
	<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Customer Details</title>
	   
	    
	    
	    <style>
	        table, th, td {
	            border: 1px solid black;
	            border-collapse: collapse;
	            padding: 8px;
	        }
	        th, td {
	            text-align: left;
	        }
	    </style>
	    
	</head>
	<body>
	    <h2>Customer Details</h2>
	     <% if (request.getAttribute("successfullMessage") != null) { %>
        <p><%= request.getAttribute("successfullMessage") %></p>
    <% } %>
	    
	     <link rel="stylesheet" type="text/css" href="home.css">
	     <form action="addCustomer.jsp">
	        <input type="submit" value="Add Customer" class="button button-green">
	    </form>
	 <form action="SearchCustomerServlet" method="get">
    <select name="searchBy"  class="button button-blue">
    <option value="searchBy" selected disabled="disabled">Search By</option>
        <option value="firstName">First Name</option>
        <option value="city">City</option>
        <option value="email">Email</option>
        <option value="phoneNumber">Phone Number</option>
    </select>
    <input type="text" name="searchText" placeholder="search" class="button">
    <input type="submit" value="Search" class="button">
</form>
<form action="SyncCustomerServlet" method="post">
    <input type="submit" value="Sync" class="button">
</form>
	    <table>
	        <thead>
	            <tr>
	                <th>Customer ID</th>
	                <th>First Name</th>
	                <th>Last Name</th>
	                <th>Street</th>
	                <th>Address</th>
	                <th>City</th>
	                <th>State</th>
	                <th>Email</th>
	                <th>Phone Number</th>
	                <th>Actions</th>
	            </tr>
	        </thead>
	        <tbody>
	            <%   
	                for (Customer customer : currentPageCustomers) { %>
	                    <tr>
	                        <td><%= customer.getuuid()%></td>
	                        <td><%= customer.getFirst_name()%></td>
	                        <td><%= customer.getLast_name()%></td>
	                        <td><%= customer.getStreet() %></td>
	                        <td><%= customer.getAddress() %></td>
	                        <td><%= customer.getCity() %></td>
	                        <td><%= customer.getState() %></td>
	                        <td><%= customer.getEmail() %></td>
	                        <td><%= customer.getPhone() %></td>
	                        <td>
	                        
	                        <% 
	   					 if (admin!= null) { 
												%>
	             <form action="EditServlet" style="display:inline;">
	                    <input type="hidden" name="customerId" value="<%= customer.getuuid() %>">
	                   <input type="submit" value="Edit" class="button button-orange" >
	                      </form>
	                   <form action="DeleteServlet" x style="display:inline;">
	                   <input type="hidden" name="customerId" value="<%= customer.getuuid() %>">
	                  <input type="submit" value="Delete"  class="button button-red" onclick="return confirm('Are you sure you want to delete this customer?');">
	                   </form>
	                    <%
					    } else {
					    	System.out.print("else");
					        response.sendRedirect("login.jsp");
					    }
	            
	                   %>
	                    </td>
	                    </tr>
	                   
	          <% } %>
	        </tbody>
	    </table>
<%-- Pagination links --%>
    <div class="pagination">
        <%-- Previous page link --%>
        <% if (currentPage > 1) { %>
            <a href="?page=<%= currentPage - 1 %>">&lt;</a>
        <% } %>

        <%-- Page number links --%>
        <% for (int i = 1; i <= totalPages; i++) { %>
            <% if (i == currentPage) { %>
                <a class="active" href="home.jsp?page=<%= i %>"><%= i %></a>
            <% } else { %>
                <a href="home.jsp?page=<%= i %>"><%= i %></a>
            <% } %>
        <% } %>

        <%-- Next page link --%>
        <% if (currentPage < totalPages) { %>
            <a href="home.jsp?page=<%= currentPage + 1%>">&gt;</a>
        <% } %>
    </div>
	</body>
	</html>
	<%} %>>