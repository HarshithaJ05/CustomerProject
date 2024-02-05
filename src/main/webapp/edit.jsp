<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.customer.module.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Customer Details</title>
     <link rel="stylesheet" type="text/css" href="edit.css">
</head>
<body>
    <h1>Edit Customer Details</h1>
    <%   Customer customer=  (Customer)request.getAttribute("customer"); %>
    <form action="UpdateServlet">
        <input type="hidden" name="customerId" value="<%= customer.getuuid() %>">
        First Name: <input type="text" name="firstName" value="<%= customer.getFirst_name() %>"><br>
        Last Name: <input type="text" name="lastName" value="<%= customer.getLast_name() %>"><br>
        Street: <input type="text" name="street" value="<%= customer.getStreet() %>"><br>
        Address: <input type="text" name="address" value="<%= customer.getAddress() %>"><br>
        City: <input type="text" name="city" value="<%= customer.getCity()%>"><br>
        State: <input type="text" name="state" value="<%= customer.getState()%>"><br>
        Email: <input type="text" name="email" value="<%= customer.getEmail()%>"><br>
        Phone Number: <input type="text" name="phoneNumber" value="<%= customer.getPhone() %>"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
