<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.fooddelivaryapp.model.Cart,com.fooddelivaryapp.model.CartItem,com.fooddelivaryapp.model.User" %>   
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="CSS/order.css">
		
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
	
	<div class="contianer">
			<h2>Your order is </h2>
			<% Cart cart=(Cart)session.getAttribute("cart1");
			double toatlAmount=0;
				for(CartItem c:cart.getItems().values()){%>
				
				<div class="items">
					<h5><%=c.getName() %> quantity : <%=c.getQuantity() %> price: <%=c.getQuantity()*c.getPrice() %></h5>
					<% toatlAmount +=c.getQuantity()*c.getPrice();%>
				</div>
				<%
				}
			%>
			<h4>total amount : <%=toatlAmount %></h4>
			<form action="home.jsp">
			<input type="submit" value="home">
			</form>
	</div>
	</body>
</html>