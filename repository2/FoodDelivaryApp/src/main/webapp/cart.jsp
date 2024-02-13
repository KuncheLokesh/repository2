<%@page import="com.fooddelivaryapp.daoimpl.MenuDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedHashMap,java.util.Map,com.fooddelivaryapp.model.Menu,com.fooddelivaryapp.model.CartItem,com.fooddelivaryapp.model.Cart,com.fooddelivaryapp.model.User" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet"  type="text/css" href="CSS/cart.css">
		
		
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
		<div class="container">
		
			<%
				MenuDaoImpl menudao=new MenuDaoImpl();
				Cart cart=(Cart)session.getAttribute("cart1");
				if(cart==null || cart.getItems().isEmpty()){
					%><h1>Your Cart is empty</h1><%
				}
				else{
				Map<Integer,CartItem> items=cart.getItems();
				for(Map.Entry<Integer,CartItem> ci:items.entrySet()){
					CartItem i=ci.getValue();
			%>
 				<div class="item">
					<form action="oder">
						<label for=""><%=i.getName() %>  &#x20B9; <%=i.getPrice() %>  Quantity</label>
						<input type="number" name="quantity" value="<%=i.getQuantity()%>" min="0">
						<input type="hidden" name="itemId" value="<%=i.getItemId()%>">
						<input type="hidden" name="restaurantId" value="<%=i.getRestaurantId() %>">
						<input type="submit" class="btn-update"name="action" value="Update">
						<input type="submit" class="btn-delete" name="action" value="remove">
						
					</form>
				</div>
				
			<%}
				if(request.getParameter("restaurantId")!=null){
					
					int id=Integer.parseInt(request.getParameter("restaurantId"));%>
					<form  action="menu1">
				<input type="submit" value="Add more items" >
				<input type="hidden" name="restaurantId" value="<%=id%>">
			</form>
			
			<form action="checkout.jsp">
				<input type="submit" class="btn-delete" value="Proceed to checkout">
			</form>
			
		</div><% 
				}
				else{
					%><h1>Your Cart is empty</h1><%
				}
				}%>
			
	</body>
</html>