<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
<link rel="stylesheet" type="text/css" href="addcustomer.css">
</head>
<body>
<h1>Add Customer</h1>
    <form action="AddCustomerServlet">
    
        <label for="uuid">UUID:</label>
        <input type="text" id="uuid" name="uuid" required><br>
        
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br>
        
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br>
        
        <label for="street">Street:</label>
        <input type="text" id="street" name="street" required><br>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br>
        
        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br>
        
        <label for="state">State:</label>
        <input type="text" id="state" name="state" required><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        
        <label for="phoneNumber">Phone Number:</label>
        <input type="number" id="phoneNumber" name="phoneNumber" required><br>
        
        <input type="submit" value="Add Customer">
    </form>



</body>
</html>