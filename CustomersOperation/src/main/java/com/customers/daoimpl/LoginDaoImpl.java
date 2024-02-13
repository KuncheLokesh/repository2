package com.customers.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.customers.dao.LoginDao;
import com.customers.model.Login;
import com.customers.util.DatabaseConnection;

public class LoginDaoImpl implements LoginDao{

	@Override
	public Login getLoginData() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM login";
		try(Connection connection =DatabaseConnection.getConnection();
				PreparedStatement preparedStatement =	connection.prepareStatement(sql)){

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String userId = resultSet.getString(1);
				String password=resultSet.getString(2);
				Login login=new Login(userId, password);
				return login;
			}

		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
