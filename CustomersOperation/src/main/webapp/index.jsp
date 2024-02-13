<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.customers.model.Customer, com.customers.daoimpl.CustomerDaoImpl, com.customers.util.JwtUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
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

        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #007BFF;
            color: #fff;
        }

        select, input {
            padding: 8px;
            margin-bottom: 10px;
        }

        button {
            background-color: #007BFF;
            width: 80px;
            height: 30px;
            padding: 8px;
            color: #fff;
            margin: 10px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }

        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .pagination a, .pagination strong {
            padding: 8px 12px;
            margin: 0 4px;
            text-decoration: none;
            color: #333;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 4px;
            cursor: pointer;
        }

        .pagination a:hover {
            background-color: #f5f5f5;
        }

        .pagination strong {
            background-color: #007bff;
            color: #fff;
        }
        #addButton {
        	width:180px;
        	height:40px;
		    background-color: #28a745;
		    color: #fff;
		    padding: 10px 15px;
		    border: none;
		    border-radius: 5px;
		    cursor: pointer;
		    font-size: 16px;
		    transition: background-color 0.3s;
		}
		
		#addButton:hover {
		    background-color: #218838;
		}
		select {
		    padding: 12px;
		    font-size: 16px;
		    border: 1px solid #ccc;
		    border-radius: 5px;
		    color: #555;
		    appearance: none;
		    background-color: #fff;
		    cursor: pointer;
		    outline: none;
		    transition: border-color 0.3s, box-shadow 0.3s;
		}
		
		select:hover {
		    border-color: #3498db;
		}
		
		select:focus {
		    border-color: #3498db;
		    box-shadow: 0 0 10px rgba(52, 152, 219, 0.7);
		}
		
		select option {
		    background-color: #fff;
		    color: #555;
		}
		
		/* Custom arrow icon */
		select::after {
		    content: '\25BC';
		    position: absolute;
		    top: 50%;
		    right: 10px;
		    transform: translateY(-50%);
		    font-size: 14px;
		    color: #777;
		    pointer-events: none;
		}
		
		/* Style for the dropdown container */
		select::-ms-expand {
		    display: none;
		}
		
		/* Improve readability on Firefox */
		@supports (-moz-appearance: none) {
		    select {
		        text-indent: 0.01px;
		        text-overflow: '';
		    }
		}
		/* Search input */
		input[type="text"] {
		    padding: 12px;
		    font-size: 16px;
		    border: 1px solid #ccc;
		    border-radius: 5px;
		    color: #555;
		    margin-right: 10px;
		    width: 200px;
		    transition: border-color 0.3s, box-shadow 0.3s;
		}
		
		input[type="text"]:focus {
		    border-color: #3498db;
		    box-shadow: 0 0 10px rgba(52, 152, 219, 0.7);
		}
		
		/* Search button */
		button[type="submit"] {
		    padding: 12px 16px;
		    height:40px;
		    font-size: 16px;
		    background-color: #3498db;
		    color: #fff;
		    border: none;
		    border-radius: 5px;
		    cursor: pointer;
		    transition: background-color 0.3s;
		}
		
		button[type="submit"]:hover {
		    background-color: #2980b9;
		}
		button#logoutButton {
		    padding: 8px 12px;
		    width:100px;
		    font-size: 16px;
		    background-color: #dc3545;
		    color: #fff;
		    border: none;
		    border-radius: 4px;
		    cursor: pointer;
		    transition: background-color 0.3s;
		    position: absolute;
		    top: 10px;
		    right: 20px;
		    display: flex;
		    align-items: center;
		    
		}
		
		button#logoutButton:hover {
		    background-color: #bd2130;
		}
		
		/* Use a symbol (e.g., "⚙️") instead of text */
		button#logoutButton::before {
		    content: "\1F6AA"; /* This unicode character represents a gear */
		    margin-right: 5px;
		}
		button.update {
		    padding: 10px 16px;
		    background-color: #28a745;
		    color: #fff;
		    border: none;
		    border-radius: 4px;
		    cursor: pointer;
		    transition: background-color 0.3s;
		}
		
		button.update:hover {
		    background-color: #218838;
		}
		button.delete {
		    padding: 10px 16px;
		    background-color: #dc3545;
		    color: #fff;
		    border: none;
		    border-radius: 4px;
		    cursor: pointer;
		    transition: background-color 0.3s;
		}
		
		button.delete:hover {
		    background-color: #bd2130;
		}
		table {
		    width: 80%;
		    border-collapse: collapse;
		    margin-top: 20px;
		    margin-bottom: 20px;
		}
		
		th, td {
		    border: 1px solid #ddd;
		    padding: 12px;
		    text-align: left;
		    height: 50px; /* Set a fixed height for the rows */
		    max-height: 100px;
		}
		#headings{
			height: 100px;
		
		}
		
		th {
		    background-color: #007BFF;
		    color: #fff;
		    
		}
		tr {
		    background-color: #fff; /* Set background color for normal state */
		    height: 130px;
		}
		
		tr:hover {
		    background-color: #f5f5f5; /* Change background color on hover */
		}
		
		#action{
			width:150px;
		}

		


    </style>
</head>
<body>
		<% 
		    String loggedInUser = (String) session.getAttribute("user");
		
		    // Check if the user is authenticated
		    if (loggedInUser == null || loggedInUser.isEmpty()) {
		        // Redirect to the login page if the user is not authenticated
		        response.sendRedirect("login.jsp");
		    }
		%>
		<%
		List<Customer> customerList=null;
		if(session.getAttribute("customerlist")!=null){
			customerList=(List<Customer>)session.getAttribute("customerlist");
			
		}else{
			CustomerDaoImpl customerdao=new CustomerDaoImpl();
			customerList=customerdao.getAllCustomers();
			
		}
		
		int totalRecords=customerList.size();
		int dataperPage=5;
		int totalPages=(int)Math.ceil((double)totalRecords/dataperPage);
		
		int currentPage=1;
		if(request.getParameter("page")!=null){
			currentPage=Integer.parseInt(request.getParameter("page"));
		}
		
		String sortBy=request.getParameter("searchBy");
		String value=request.getParameter("searchValue");
		
		%>
		<button id="logoutButton" onclick="window.location.href='logout'">Logout</button>
		
		<form action="searchServlet" method="get">
		<button id="addButton" onclick="window.location.href='customerList'">All Customers</button>
		<button id="addButton" onclick="window.location.href='addCustomer.jsp'">Add Customer</button>	
		    <select name="searchBy">
		        <option value="firstname">Search by First Name</option>
		        <option value="city">Search by City</option>
		        <option value="email">Search by Email</option>
		        <option value="phone">Search by Phone</option>
		        <option value="state">Search by State</option>
		    </select>
		    <input type="text" name="searchValue" required>
		    <button type="submit">Search</button>
		    
		</form>
		
		<table>
	    <tr id="headings">
	        <th>First Name</th>
	        <th>Last Name</th>
	        <th>Street</th>
	        <th>Address</th>
	        <th>City</th>
	        <th>State</th>
	        <th>Email</th>
	        <th>Phone</th>
	        <th>Actions</th>
	    </tr>

	    <% 
	        if (customerList != null && !customerList.isEmpty()) {
	            for (int i = (currentPage-1)*5; i < currentPage*5; i++) {
	            	if(i<0){
	            		continue;
	            	}
	            	if(i>=customerList.size()){
	            		break;
	            	}
	                Customer customer = customerList.get(i);
	    %>
	                <tr>
	                    <td><%=customer.getFirstName() %></td>
	                    <td><%=customer.getLastName() %></td>
	                    <td><%=customer.getStreet() %></td>
	                    <td><%=customer.getAddress()%></td>
	                    <td><%=customer.getCity()%></td>
	                    <td><%=customer.getState()%></td>
	                    <td><%=customer.getEmail()%></td>
	                    <td><%=customer.getPhone() %></td>
	                    <td id="action">
	                        <button class="update" onclick="window.location.href='updateCustomer.jsp?id=<%=customer.getId()%>'">Update</button>
	                        <button class="delete" onclick="window.location.href='deleteCustomerServlet?id=<%=customer.getId()%>'">Delete</button>
	                    </td>
	                </tr>
	    <%
	            }
	        }
	    %>
	</table>
	
		<div class="pagination">
	    <%
	        int pageSize = 5; // Adjust the page size as needed
	        totalPages = (int) Math.ceil((double) totalRecords / pageSize);
	        
	
	        if (currentPage > 1) {
	    %>
	            <a href="customerList?page=<%= currentPage - 1 %>">Previous</a>
	    <%
	        }
	
	        for (int i = 1; i <= totalPages; i++) {
	            if (i == currentPage) {
	    %>
	                <strong><%= i %></strong>
	    <%
	            } else {
	    %>
	                <a href="customerList?page=<%= i %>"><%= i %></a>
	    <%
	            }
	        }
	
	        if (currentPage < totalPages) {
	    %>
	            <a href="customerList?page=<%= currentPage + 1 %>">Next</a>
	    <%
	        }
	    %>
	</div>
	

</body>
</html>