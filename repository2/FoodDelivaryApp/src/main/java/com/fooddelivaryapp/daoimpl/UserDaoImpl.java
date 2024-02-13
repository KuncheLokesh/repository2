package com.fooddelivaryapp.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivaryapp.dao.UserDao;
import com.fooddelivaryapp.model.User;

public class UserDaoImpl implements  UserDao{
	
	private static Connection connection=null;
	private static Statement statement=null;
	private static PreparedStatement statement1=null;
	private static ResultSet resultset=null;
	
	private static final String USER_NAME="root";
	private static final String PASSWORD="root";
	private static final String URL="jdbc:mysql://localhost:3306/foodapp";
	
	private static final String INSERT_QUERY="INSERT INTO `user` ( `username`, `password`, `email`) VALUES ( ?, ?, ?)";
	private static final String SELECT_QUERY="select * from `user`";
	private static final String DELETE_QUERY="delete from `user` where `userId`=?";
	private static final String UPDATE_QUERY="update `user` set `username`=?,`password`=?,`email`=?,`address`=?,`role`=? where `userId`=?";
	private static final String GEt_QUERY="select * from `user` where `userId`=?";
	
	
	public UserDaoImpl() {

			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
		try {
			statement1=connection.prepareStatement(INSERT_QUERY);
			statement1.setString(1, user.getUserName());
			statement1.setString(2, user.getPassword());
			statement1.setString(3, user.getEmail());
			statement1.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		
		try {
			statement1= connection.prepareStatement(GEt_QUERY);
			statement1.setInt(1, userId);
			resultset = statement1.executeQuery();
			
			while(resultset.next()) {
				String name=resultset.getString("username");
				String password=resultset.getString("password");
				String email=resultset.getString("email");
				int userId1=resultset.getInt("userId");
				String role=resultset.getString("role");
				String address=resultset.getString("address");
				
				User user=new User(userId1,name,password,email,address,role);
				return user;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		try {
			statement1 = connection.prepareStatement(UPDATE_QUERY);
			statement1.setString(1, user.getUserName());
			statement1.setString(2, user.getPassword());
			statement1.setString(3, user.getEmail());
			statement1.setString(4, user.getAddress());
			statement1.setString(5, user.getRole());
			statement1.setInt(6,user.getUserId());
			statement1.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
		try {
			statement1 = connection.prepareStatement(DELETE_QUERY);
			statement1.setInt(1, userId);
			statement1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<User> list=new ArrayList<>();
		try {
			statement = connection.createStatement();
			resultset = statement.executeQuery(SELECT_QUERY);
			
			while(resultset.next()){
				String name=resultset.getString("Username");
				int id=resultset.getInt("UserID");
				String password=resultset.getString("Password");
				String email=resultset.getString("email");
				String address=resultset.getString("Address");
				String role=resultset.getString("Role");
				
				User user=new User(id, name, password, email, address, role);
				list.add(user);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
