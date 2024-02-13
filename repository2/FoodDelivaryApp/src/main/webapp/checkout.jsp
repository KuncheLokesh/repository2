<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.fooddelivaryapp.model.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>check out page</title>
		<link rel="stylesheet" href="CSS/chechkout.css">
		
	</head>
	<body>
	
		<header>
			<nav>
				<ul>
					<li><a href="home.jsp">Home</a></li>
					<% if(session.getAttribute("user")!=null){
						User user=(User)session.getAttribute("user");
						%>
						<li><p><%=user.getUserName() %></p></li>
						<%
					}
					else{
						%><li><a href="login.jsp">Login</a></li><% 
					}
						
						%>
					
						
				</ul>
			</nav>
		</header>
		<form action="processPayment" method="post">
        <label for="address">Address:</label>
        <textarea id="address" name="address" rows="4" required></textarea>

        <label for="paymentMethod">Payment Method:</label>
        <select id="paymentMethod" name="paymentMethod" required>
            <option value="UPI">UPI</option>
            <option value="Debit Card">Debit Card</option>
            <option value="Credit Card">Credit Card</option>
            <option value="Cash">Cash</option>
        </select>

        <button type="submit">Submit</button>
    </form>
	
	</body>
</html>