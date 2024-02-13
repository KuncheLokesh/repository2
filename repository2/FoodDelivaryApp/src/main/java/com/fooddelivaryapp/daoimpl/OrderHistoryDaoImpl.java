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

import com.fooddelivaryapp.dao.OrderHistoryDao;
import com.fooddelivaryapp.model.OrderHistory;

public class OrderHistoryDaoImpl implements OrderHistoryDao {
	
	private static Connection connection=null;
	private static Statement statement=null;
	private static PreparedStatement statement1=null;
	private static ResultSet resultset=null;
	
	private static final String USER_NAME="root";
	private static final String PASSWORD="root";
	private static final String URL="jdbc:mysql://localhost:3306/foodapp";
	
	
	private static final String INSERT_QUERY="INSERT INTO `orderhistory` (`UserID`,`OrderID`,`TotalAmount`,`Status`) VALUES (?,?,?,?)";
	private static final String SELECT_QUERY="SELECT * FROM `orderhistory` WHERE `OrderHistoryID`=?";
	private static final String DELETE_QUERY="DELETE FROM `orderhistory` WHERE `OrderHistoryID`=?";
	private static final String UPDATE_QUERY="UPDATE `orderhistory` SET `UserID`=?,`OrderID`=?,`TotalAmount`=?,`Status`=? WHERE `OrderHistoryID`=?";
	private static final String GEt_QUERY="SELECT * FROM `orderhistory` WHERE `UserID`=?";
	

	public OrderHistoryDaoImpl() {
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
	public void addOderHistory(OrderHistory oderHistory) {
		// TODO Auto-generated method stub
		
		try {
			statement1 = connection.prepareStatement(INSERT_QUERY);
			statement1.setInt(1, oderHistory.getUserId());
			statement1.setInt(2, oderHistory.getOrderId());
			statement1.setDouble(3, oderHistory.getOrderTotalAmount());
			statement1.setString(4, oderHistory.getStatus());
			statement1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {
		// TODO Auto-generated method stub
		
		
		try {
			statement1= connection.prepareStatement(SELECT_QUERY);
			statement1.setInt(1, orderHistoryId);
			resultset = statement1.executeQuery();
			
			while(resultset.next()) {
				int id=resultset.getInt("OrderHistoryID");
				int userId=resultset.getInt("UserID");
				int oderId=resultset.getInt("OrderID");
				Date date=resultset.getDate("OrderDate");
				double totalAmount=resultset.getDouble("TotalAmount");
				String status=resultset.getString("Status");
				
				OrderHistory orderHistory=new OrderHistory(orderHistoryId, userId, oderId, date, totalAmount, status);
				return orderHistory;
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	

	@Override
	public void updateOrderHistory(OrderHistory orderHistoryDao) {
		// TODO Auto-generated method stub
		
		try {
			statement1=connection.prepareStatement(UPDATE_QUERY);
			statement1.setInt(1, orderHistoryDao.getUserId());
			statement1.setInt(2, orderHistoryDao.getOrderId());
			statement1.setDouble(3, orderHistoryDao.getOrderTotalAmount());
			statement1.setString(4, orderHistoryDao.getStatus());
			statement1.setInt(5, orderHistoryDao.getOrderHistoryId());
			statement1.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	
	
	
	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		// TODO Auto-generated method stub
		
		
		try {
			statement1=connection.prepareStatement(DELETE_QUERY);
			statement1.setInt(1, orderHistoryId);
			statement1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	@Override
	public List<OrderHistory> getAllOrderHistory(int userId) {
		// TODO Auto-generated method stub
		
		List<OrderHistory> list=new ArrayList<OrderHistory>();
		try {
			statement1=connection.prepareStatement(GEt_QUERY);
			statement1.setInt(1, userId);
			resultset = statement1.executeQuery();
			
			while(resultset.next()) {
				int id=resultset.getInt("OrderHistoryID");
				int userId1=resultset.getInt("UserID");
				int oderId=resultset.getInt("OrderID");
				Date date=resultset.getDate("OrderDate");
				double totalAmount=resultset.getDouble("TotalAmount");
				String status=resultset.getString("Status");
				
				OrderHistory orderHistory=new OrderHistory(id, userId1, oderId, date, totalAmount, status);
				list.add(orderHistory);
				
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	

}
