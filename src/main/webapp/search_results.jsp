<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.customer.module.Customer" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
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
 <link rel="stylesheet" type="text/css" href="home.css">
<body>
    <h2>Search Results</h2>
    <form action="home.jsp">
    <input type="submit"  value="home">
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
                <th>state</th>
                <th>Email</th>
                <th>Phone Number</th>
            </tr>
        </thead>
        <tbody>
            <% if (request.getAttribute("resultSet") != null) {
                List<Customer> resultSet = (List<Customer>) request.getAttribute("resultSet");
                for (Customer customer : resultSet) { %>
                    <tr>
                        <td><%= customer.getuuid() %></td>
                        <td><%= customer.getFirst_name() %></td>
                        <td><%= customer.getLast_name() %></td>
                        <td><%= customer.getStreet() %></td>
                        <td><%= customer.getAddress() %></td>
                        <td><%= customer.getCity() %></td>
                        <td><%= customer.getState() %></td>
                        <td><%= customer.getEmail() %></td>
                        <td><%= customer.getPhone() %></td>
                    </tr>
                        
                <% }
                
            } else { %>
                     
                <tr>
                    <td colspan="8"><%= request.getAttribute("message") %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
