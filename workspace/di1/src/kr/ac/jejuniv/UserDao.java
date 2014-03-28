package kr.ac.jejuniv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {

	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	public UserDao() {
	}
	
	

	public User get(String id) throws SQLException, ClassNotFoundException {
		Connection connection = connectionMaker.getConnection();
		String sql = "select id, name, password from userinfo where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		User user = new User();
		user.setId(resultSet.getString("id"));
		user.setName(resultSet.getString("name"));
		user.setPassword(resultSet.getString("password"));
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return user;
	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection connection = connectionMaker.getConnection();
		String sql = "insert into userinfo(id, name, password) values (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
		
	}

	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
		
	}


}
