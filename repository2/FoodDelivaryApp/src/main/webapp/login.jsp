<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="CSS/login.css">
		<style>
			.button-container{
			display:flex;
			justify-content:space-around;
			width:100%;
			margin:10px;
			}
		</style>
	</head>
	<body>
		 <div class="login-container">
        <h2>Login Page</h2>
        

        <form action="checklgoin" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <div class="button-container">
                <button type="submit">Login</button>
                </form>
                <form action="signup.jsp">
                    <button id="signup" style="background-color:#3652AD" type="submit">SignUp</button>
                </form>
            </div>
       
   		 </div>
		
	</body>
</html>