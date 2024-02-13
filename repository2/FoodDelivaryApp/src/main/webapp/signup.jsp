<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>SignUppage</title>
		<link rel="stylesheet" href="CSS/signup.css">
	</head>
	<body>
		<form action="signUp" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <%if(request.getAttribute("warning")!=null){
            	%><span style="color: red;"><%=request.getAttribute("warning")%></span><%
            }%>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>

            <button type="submit">Sign Up</button>
        </form>
	</body>
</html>