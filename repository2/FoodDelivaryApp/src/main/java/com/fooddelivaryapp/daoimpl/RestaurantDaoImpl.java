package com.fooddelivaryapp.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivaryapp.dao.RestaurantDao;
import com.fooddelivaryapp.model.Restaurant;
import com.fooddelivaryapp.model.User;

public class RestaurantDaoImpl implements RestaurantDao {
	
	
	private static Connection connection=null;
	private static Statement statement=null;
	private static PreparedStatement statement1=null;
	private static ResultSet resultset=null;
	
	private static final String USER_NAME="root";
	private static final String PASSWORD="root";
	private static final String URL="jdbc:mysql://localhost:3306/foodapp";
	
	private static final String INSERT_QUERY="INSERT INTO `restaurant` (`Name`, `CuisineType`, `DeliveryTime`,`Address`,`AdminUserID`) VALUES (?, ?, ?,?,?)";
	private static final String SELECT_QUERY="SELECT * FROM `restaurant`";
	private static final String DELETE_QUERY="DELETE FROM `restaurant` where `RestaurantID`=?";
	private static final String UPDATE_QUERY="UPDATE `restaurant` set `Name`=?,`CuisineType`=?,`DeliveryTime`=?,`Address`=?,`AdminUserID`=?,`ImagePath`=?,`IsActive`=?,`Rating`=? WHERE `RestaurantID`=?";
	private static final String GEt_QUERY="SELECT * FROM `restaurant` where `RestaurantID`=?";

	
	
	
	public RestaurantDaoImpl() {
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
	public void addRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		try {
			statement1=connection.prepareStatement(INSERT_QUERY);
			
			statement1.setString(1, restaurant.getName());
			statement1.setString(2, restaurant.getCuisineType());
			statement1.setInt(3, restaurant.getEta());
			statement1.setString(4, restaurant.getAddress());
			statement1.setInt(5, restaurant.getAdimUserId());
			
			statement1.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	@Override
	public Restaurant getRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		
		try {
			statement1= connection.prepareStatement(GEt_QUERY);
			statement1.setInt(1, restaurantId);
			resultset = statement1.executeQuery();
			
			while(resultset.next()) {
				int id=resultset.getInt("restaurantId");
				String name=resultset.getString("Name");
				String cuisineType=resultset.getString("CuisineType");
				int eta=resultset.getInt("DeliveryTime");
				int adminUserID=resultset.getInt("AdminUserID");
				float rating=resultset.getFloat("Rating");
				String imagePath=resultset.getString("ImagePath");
				String address=resultset.getString("Address");
				boolean active=resultset.getBoolean("IsActive");
				
				Restaurant restaurant=new Restaurant(restaurantId, name, cuisineType, eta, address, adminUserID, rating, active, imagePath);
				return restaurant;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
	@Override
	public void updateRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		//"UPDATE `restaurant` set `Name`=?,`CuisineType`=?,`DeliveryTime`=?,`Address`=?,`AdminUserID`=?,`ImagePath`=?,`IsActive`=?,`Rating`=? WHERE `RestaurantID`=?";
		try {
			statement1 = connection.prepareStatement(UPDATE_QUERY);
			statement1.setString(1, restaurant.getName());
			statement1.setString(2, restaurant.getCuisineType());
			statement1.setInt(3, restaurant.getEta());
			statement1.setString(4, restaurant.getAddress());
			statement1.setInt(5, restaurant.getAdimUserId());
			statement1.setString(6, restaurant.getImagePath());
			statement1.setBoolean(7, restaurant.getisActive());
			statement1.setFloat(8, restaurant.getRating());
			statement1.setInt(9, restaurant.getRestaurantId());
			statement1.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	@Override
	public void deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		try {
			statement1 = connection.prepareStatement(DELETE_QUERY);
			statement1.setInt(1, restaurantId);
			statement1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		
		List<Restaurant> list=new ArrayList<>();
		try {
			statement = connection.createStatement();
			resultset = statement.executeQuery(SELECT_QUERY);
			
			while(resultset.next()) {
				int id=resultset.getInt("restaurantId");
				String name=resultset.getString("Name");
				String cuisineType=resultset.getString("CuisineType");
				int eta=resultset.getInt("DeliveryTime");
				int adminUserID=resultset.getInt("AdminUserID");
				float rating=resultset.getFloat("Rating");
				String imagePath=resultset.getString("ImagePath");
				String address=resultset.getString("Address");
				boolean active=resultset.getBoolean("IsActive");
				
				Restaurant restaurant=new Restaurant(id, name, cuisineType, eta, address, adminUserID, rating, active, imagePath);
				list.add(restaurant);
				
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
