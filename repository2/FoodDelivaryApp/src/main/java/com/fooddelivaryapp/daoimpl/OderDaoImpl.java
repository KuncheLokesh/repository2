package com.fooddelivaryapp.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fooddelivaryapp.dao.OderDao;
import com.fooddelivaryapp.model.Menu;
import com.fooddelivaryapp.model.OrderTable;

public class OderDaoImpl implements OderDao {
	
	private static Connection connection=null;
	private static Statement statement=null;
	private static PreparedStatement statement1=null;
	private static ResultSet resultset=null;
	
	private static final String USER_NAME="root";
	private static final String PASSWORD="root";
	private static final String URL="jdbc:mysql://localhost:3306/foodapp";
	//( `OrderID`,`UserID`,`RestaurantID`, `TotalAmount`,`Status`,`PaymentMethod`)
	
	private static final String INSERT_QUERY="INSERT INTO `ordertable` ( `OrderID`,`UserID`,`RestaurantID`, `TotalAmount`,`PaymentMethod`) VALUES (?,?,?,?,?)";
	private static final String SELECT_QUERY="select * from `ordertable` WHERE `OrderID`=?";
	private static final String DELETE_QUERY="delete from `ordertable` where `OrderID`=?";
	private static final String UPDATE_QUERY="update `ordertable` set `RestaurantID`=?,`UserID`=?,`Status`=?,`TotalAmount`=?,`PaymentMethod`=? where `OrderID`=?";
	private static final String GEt_QUERY="select * from `ordertable` where `OrderID`=?";
	
	
	
	
	
	
	
	public OderDaoImpl() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	@Override
	public void addOder(OrderTable oder) {
		// TODO Auto-generated method stub
		try {
			statement1=connection.prepareStatement(INSERT_QUERY);
			statement1.setInt(1, oder.getOrderId());
			statement1.setInt(2,oder.getUserId());
			statement1.setInt(3,oder.getRestaurantId());
			statement1.setDouble(4, oder.getTotalAmount());
			statement1.setString(5,oder.getPaymentMethod());
			statement1.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	@Override
	public OrderTable getOder(int oderId) {
		// TODO Auto-generated method stub
		
		//( `OrderID`,`UserID`,`RestaurantID`, `TotalAmount`,`Status`,`PaymentMethod`)
		
		try {
			statement1= connection.prepareStatement(GEt_QUERY);
			statement1.setInt(1, oderId);
			resultset = statement1.executeQuery();
			
			while(resultset.next()) {
				int id=resultset.getInt("OrderID");
				int userid=resultset.getInt("UserID");
				int restaurantId=resultset.getInt("RestaurantID");
				double totalAmount=resultset.getDouble("TotalAmount");
				String status=resultset.getString("Status");
				String paymentMode=resultset.getString("PaymentMethod");
				Date date=resultset.getDate("OrderDate");
				
				OrderTable oder=new OrderTable(oderId, userid, restaurantId, date, totalAmount, status, paymentMode);
				
				return oder;
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
	
	@Override
	public void updateOrder(OrderTable order) {
		//update `ordertable` set `RestaurantID`=?,`UserID`=?,`Status`=?,`TotalAmount`=?,``PaymentMethod`=? where `OrderID`=?
		
		try {
			statement1=connection.prepareStatement(UPDATE_QUERY);
			
			
			statement1.setInt(1,order.getRestaurantId());
			statement1.setInt(2,order.getUserId());
			statement1.setString(3,order.getStatus());
			statement1.setDouble(4, order.getTotalAmount());
			statement1.setString(5,order.getPaymentMethod());
			statement1.setInt(6, order.getOrderId());
			
			statement1.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	@Override
	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		try {
			statement1 = connection.prepareStatement(DELETE_QUERY);
			statement1.setInt(1, orderId);
			statement1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public List<OrderTable> getAllOrder() {
		// TODO Auto-generated method stub
		
		List<OrderTable> list=new ArrayList<>();
		try {
			statement = connection.createStatement();
			
			resultset = statement.executeQuery(SELECT_QUERY);
			
			while(resultset.next()) {
				int id=resultset.getInt("OrderID");
				int userid=resultset.getInt("UserID");
				int restaurantId=resultset.getInt("RestaurantID");
				double totalAmount=resultset.getDouble("TotalAmount");
				String status=resultset.getString("Status");
				String paymentMode=resultset.getString("PaymentMethod");
				Date date=resultset.getDate("OrderDate");
				
				OrderTable oder=new OrderTable(id, userid, restaurantId, date, totalAmount, status, paymentMode);
				
				list.add(oder);
				
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
