<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.fooddelivaryapp.daoimpl.RestaurantDaoImpl,com.fooddelivaryapp.model.Restaurant,com.fooddelivaryapp.model.User,com.fooddelivaryapp.daoimpl.UserDaoImpl,java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="CSS/home.css">
		<style type="text/css">
		

		</style>
		
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
						<li><a href="logout">logOut</a></li>
						<%
					}
					else{
						%><li><a href="login.jsp">Login</a></li>
						  
						<% 
					}
					
						
						%>
						
						<li><a href="cart.jsp">Cart</a></li>
						<li><form id="myForm" action="sort" method="post">
							  <li>
							    <a>
							      <select id="cuisineSelect" name="cuisine">
							        <option value="none">None</option>
							        <option value="south indian">South Indian</option>
							        <option value="Italian">Italian</option>
							        <option value="Mexican">Mexican</option>
							        <option value="Barbecue">Barbecue</option>
							        <option value="Seafood">Seafood</option>
							        <option value="French">French</option>
							        <option value="Japanese">Japanese</option>
							      </select>
							      <input type="submit" hidden="true" value="Submit">
							    </a>
							  </li>
						</form></li>
						<script>
						  document.getElementById('cuisineSelect').addEventListener('change', function() {
						    document.getElementById('myForm').submit();
						  });
						</script>
					
						
				</ul>
			</nav>
		</header>
	
	<div class="container">
		<%
		List<Restaurant> restaurant=null;
		if(session.getAttribute("restaurants")!=null){
			restaurant=(List<Restaurant>)session.getAttribute("restaurants");
		}
		else{
			RestaurantDaoImpl dao=new RestaurantDaoImpl();
			restaurant=dao.getAllRestaurant();
			
		}
		for(Restaurant res:restaurant){
		
		%>
		<div class="restaurant">
			<img alt="image not there" src="<%= res.getImagePath()%>"> 
			<h2>Name : <%=res.getName() %></h2>
			<h2>Rating : <%=res.getRating() %></h2>
			<h2>Cuisine : <%=res.getCuisineType() %></h2>
			<h2>delivary time: <%=res.getEta() %>min</h2>
			<a href="menu1?restaurantId=<%=res.getRestaurantId()%>"><button type="submit">Menu</button></a>
		</div>
		
		<%}%>
		
		
	</div>
	<footer>
        <p>&copy; 2024 Your Company. All rights reserved.</p>
    </footer>
	
	
	</body>
</html>