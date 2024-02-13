package com.fooddelivaryapp.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddelivaryapp.dao.MenuDao;
import com.fooddelivaryapp.model.Menu;

public class MenuDaoImpl implements MenuDao {
	
	private static Connection connection=null;
	private static Statement statement=null;
	private static PreparedStatement statement1=null;
	private static ResultSet resultset=null;
	
	private static final String USER_NAME="root";
	private static final String PASSWORD="root";
	private static final String URL="jdbc:mysql://localhost:3306/foodapp";
	
	private static final String INSERT_QUERY="INSERT INTO `Menu` (`MenuID`, `RestaurantID`, `ItemName`, `Price`) VALUES (?, ?, ?, ?)";
	private static final String SELECT_QUERY="select * from `Menu` WHERE `RestaurantID`=?";
	private static final String DELETE_QUERY="delete from `user` where `MenuID`=?";
	private static final String UPDATE_QUERY="update `Menu` set `RestaurantID`=?,`ItemName`=?,`Description`=?,`Price`=?,`IsAvailable`=? where `MenuID`=?";
	private static final String GEt_QUERY="select * from `Menu` where `menuId`=?";
	
	
	

	public MenuDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	

	@Override
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		try {
			statement1=connection.prepareStatement(INSERT_QUERY);
			statement1.setInt(1, menu.getMenuId());
			statement1.setInt(2, menu.getRestaurantId());
			statement1.setString(3, menu.getItemName());
			statement1.setDouble(4, menu.getPrice());
			statement1.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Menu getMenu(int menuId) {
		// TODO Auto-generated method stub
		try {
			statement1= connection.prepareStatement(GEt_QUERY);
			statement1.setInt(1, menuId);
			resultset = statement1.executeQuery();
			
			while(resultset.next()) {
				int id=resultset.getInt("menuId");
				int restaurantId=resultset.getInt("RestaurantID");
				String itemName=resultset.getString("ItemName");
				String discription=resultset.getString("Description");
				double price=resultset.getDouble("Price");
				boolean isAvailable=resultset.getBoolean("IsAvailable");
				
				Menu menu=new Menu(menuId, restaurantId, itemName, discription, price, isAvailable);
				return menu;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	@Override
	public void updateMenu(Menu menu) {
		//"update `Menu` set `RestaurantID`=?,`ItemName`=?,`Description`=?,`Price`=?,`IsAvailable`=? where `MenuID`=?";
			
		try {
			statement1 = connection.prepareStatement(UPDATE_QUERY);
			statement1.setInt(1, menu.getRestaurantId());
			statement1.setString(2, menu.getItemName());
			statement1.setString(3, menu.getDescription());
			statement1.setDouble(4, menu.getPrice());
			statement1.setBoolean(5, menu.getisAvialable());
			statement1.setInt(6,menu.getMenuId());
			statement1.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteMenu(int menuId) {
		// TODO Auto-generated method stub
		
		try {
			statement1 = connection.prepareStatement(DELETE_QUERY);
			statement1.setInt(1, menuId);
			statement1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Menu> getAllMenuByRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		
		List<Menu> list=new ArrayList<>();
		try {
			statement1 = connection.prepareStatement(SELECT_QUERY);
			statement1.setInt(1, restaurantId);
			resultset = statement1.executeQuery();
			
			while(resultset.next()) {
				int id=resultset.getInt("MenuID");
				int restid=resultset.getInt("RestaurantID");
				String itemName=resultset.getString("ItemName");
				String description=resultset.getString("Description");
				double price=resultset.getDouble("Price");
				boolean isAvailable=resultset.getBoolean("IsAvailable");
				
				Menu menu =new Menu(id, restaurantId, itemName, description, price, isAvailable);
				list.add(menu);
				
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
