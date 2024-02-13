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

import com.fooddelivaryapp.dao.OrderItemDao;
import com.fooddelivaryapp.model.OrderItem;
import com.fooddelivaryapp.model.OrderTable;

public class OrderItemDaoImpl implements OrderItemDao{
	
	
	private static Connection connection=null;
	private static Statement statement=null;
	private static PreparedStatement statement1=null;
	private static ResultSet resultset=null;
	
	private static final String USER_NAME="root";
	private static final String PASSWORD="root";
	private static final String URL="jdbc:mysql://localhost:3306/foodapp";
	
	private static final String INSERT_QUERY="INSERT INTO `orderitem` ( `OrderItemID`,`OrderID`,`MenuID`, `Quantity`,`ItemTotal`) VALUES (?,?,?,?,?)";
	private static final String SELECT_QUERY="select * from `orderitem` WHERE `OrderID`=?";
	private static final String DELETE_QUERY="delete from `orderitem` where `OrderID`=?";
	private static final String UPDATE_QUERY="update `orderitem` set `OrderID`=?,`MenuID`=?,`Quantity`=?,`ItemTotal`=? where `OrderItemID`=?";
	private static final String GEt_QUERY="select * from `orderitem` where `OrderId`=?";
	
	
	
	

	public OrderItemDaoImpl() {
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
	public void addOderItem(OrderItem oderItem) {
		// TODO Auto-generated method stub
		
		try {
			statement1 = connection.prepareStatement(INSERT_QUERY);
			statement1.setInt(1, oderItem.getOrderItemId());
			statement1.setInt(2,oderItem.getOrderId());
			statement1.setInt(3, oderItem.getMenuId());
			statement1.setInt(4, oderItem.getQuantity());
			statement1.setDouble(5, oderItem.getItemToatal());
			statement1.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	@Override
	public OrderItem getOderItem(int oderItemId) {
		// TODO Auto-generated method stub
		
		try {
			statement1= connection.prepareStatement(GEt_QUERY);
			statement1.setInt(1, oderItemId);
			resultset = statement1.executeQuery();
			
			while(resultset.next()) {
				int id=resultset.getInt("OrderItemID");
				int oderId=resultset.getInt("OrderID");
				int menuId=resultset.getInt("MenuID");
				int quantity=resultset.getInt("Quantity");
				double itemTotal=resultset.getDouble("ItemTotal");
				
				
				OrderItem oderItem=new OrderItem(id, oderId, menuId, quantity, itemTotal);
				
				return oderItem;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	
	
	@Override
	public void updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		
		try {
			statement1=connection.prepareStatement(UPDATE_QUERY);
			
			
			statement1.setInt(1,orderItem.getOrderId());
			statement1.setInt(2,orderItem.getMenuId());
			statement1.setInt(3,orderItem.getQuantity());
			statement1.setDouble(4, orderItem.getItemToatal());
			statement1.setInt(5,orderItem.getOrderItemId());
			statement1.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
	@Override
	public void deleteOrder(int orderItemId) {
		// TODO Auto-generated method stub
		try {
			statement1 = connection.prepareStatement(DELETE_QUERY);
			statement1.setInt(1, orderItemId);
			statement1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	@Override
	public  List<OrderItem> getAllOrderItem(int OrderId) {
		// TODO Auto-generated method stub
		
		
		List<OrderItem> list=new ArrayList<>();
		try {
			statement1 = connection.prepareStatement(SELECT_QUERY);
			statement1.setInt(1, OrderId);
			resultset = statement1.executeQuery();
			
			while(resultset.next()) {
				int id=resultset.getInt("OrderItemID");
				int oderId=resultset.getInt("OrderID");
				int menuId=resultset.getInt("MenuID");
				int quantity=resultset.getInt("Quantity");
				double itemTotal=resultset.getDouble("ItemTotal");
				
				
				OrderItem oderItem=new OrderItem(id, oderId, menuId, quantity, itemTotal);
				
				list.add(oderItem);
				
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
