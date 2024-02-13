package com.customers.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customers.dao.CustomerDao;
import com.customers.model.Customer;
import com.customers.util.DatabaseConnection;

public class CustomerDaoImpl  implements CustomerDao{

	private static final String INSERT_CUSTOMER_SQL =
            "INSERT INTO customer (firstname, lastname, street, address, city, state, email, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_CUSTOMER_BY_ID_SQL =
            "SELECT * FROM customer WHERE id = ?";

    private static final String SELECT_ALL_CUSTOMERS_SQL =
            "SELECT * FROM customer";

    private static final String UPDATE_CUSTOMER_SQL =
            "UPDATE customer SET firstname = ?, lastname = ?, street = ?, address = ?, city = ?, state = ?, email = ?, phone = ? WHERE id = ?";

    private static final String DELETE_CUSTOMER_SQL =
            "DELETE FROM customer WHERE id = ?";

    @Override
    public int addCustomer(Customer customer) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL,
                     Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getStreet());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getCity());
            preparedStatement.setString(6, customer.getState());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getPhone());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating customer failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getStreet());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getCity());
            preparedStatement.setString(6, customer.getState());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getPhone());
            preparedStatement.setInt(9, customer.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Customer customer = mapResultSetToCustomer(resultSet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    customer = mapResultSetToCustomer(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public int deleteCustomer(Customer customer) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customer.getId());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private Customer mapResultSetToCustomer(ResultSet resultSet) throws SQLException {
        return new Customer(
                resultSet.getInt("id"),
                resultSet.getString("firstname"),
                resultSet.getString("lastname"),
                resultSet.getString("street"),
                resultSet.getString("address"),
                resultSet.getString("city"),
                resultSet.getString("state"),
                resultSet.getString("email"),
                resultSet.getString("phone")
        );
    }


	@Override
	public List<Customer> getAllCustomers(String sortBy, String value) {
	    String sql = "SELECT * FROM customer WHERE " + sortBy + " LIKE ?";
	    value = "%" + value + "%";

	    List<Customer> customers = new ArrayList<>();
	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, value);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                Customer customer = mapResultSetToCustomer(resultSet);
	                customers.add(customer);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return customers;
	}




}
