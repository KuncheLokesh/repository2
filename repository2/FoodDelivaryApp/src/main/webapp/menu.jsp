<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List,com.fooddelivaryapp.model.Menu,java.util.LinkedHashMap,com.fooddelivaryapp.model.Cart,com.fooddelivaryapp.model.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="CSS/menu.css">
		
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
				List<Menu> list= (List<Menu>) request.getAttribute("menu");
			if(list.size() !=0){
				LinkedHashMap<Integer,Integer> map=new LinkedHashMap<Integer,Integer>();
				session.setAttribute("cart", map);
				for(Menu menu:list){
			%>
			<div class="menu-item">
				
				<h3><%=menu.getItemName() %></h3>
				<h5><%=menu.getDescription() %></h5>
				<p>Price :<%=menu.getPrice() %></p>
				<form action="cart" method="get">
        			<label for="quantity">Quantity</label>
        			<input type="number" value="1" id="quantity" name="quantity" min="1">
        			<input type="hidden" name="restaurantId" value="<%= menu.getRestaurantId() %>">
    				<input type="hidden" name="menuId" value="<%= menu.getMenuId() %>"><br>
        			<button type="submit">Add to Cart</button>
    			</form>
				
			</div>
			<%
			}
			}
			else{%>
				<h2>menu is not added at</h2>
			<% }%>
		
		</div>
	
	</body>
</html>