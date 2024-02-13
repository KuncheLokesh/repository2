<%@page import="com.customers.daoimpl.CustomerDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.customers.model.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 50%;
            margin-top: 50px;
        }

        input {
            padding: 8px;
            margin-bottom: 10px;
            width: 100%;
        }

        button {
            background-color: #007BFF;
            width: 100%;
            padding: 8px;
            color: #fff;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
    </style>
</head>
<body>

	<% CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
	Customer customer=customerDaoImpl.getCustomerById(Integer.parseInt(request.getParameter("id")));
	System.out.println(Integer.parseInt(request.getParameter("id")));
	System.out.println(customer);
	%>

<div class="container">

    <h2>Update  Customer</h2>

    <form action="updateCustomerServlet?id=<%=request.getParameter("id")%>" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName"  value="<%=customer.getFirstName() %> "required>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="<%=customer.getLastName() %>" required>

        <label for="street">Street:</label>
        <input type="text" id="street" name="street" value="<%=customer.getStreet() %>" required>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="<%=customer.getAddress() %>" required>

        <label for="city">City:</label>
        <input type="text" id="city" name="city" value="<%=customer.getCity() %>" required>

        <label for="state">State:</label>
        <input type="text" id="state" name="state" value="<%=customer.getState() %>" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%=customer.getEmail() %>" required>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" value=<%=customer.getPhone() %> required>

        <button type="submit">Update Customer</button>
    </form>
</div>

</body>
</html>
