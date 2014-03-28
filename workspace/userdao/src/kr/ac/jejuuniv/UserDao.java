package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	public User get(String id) throws SQLException, ClassNotFoundException {
		//Connection 을 하자
		Connection connection = getConnection();
		//쿼리를 만들고
		String query = "select id, name, password from userinfo where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, id);
		//실행하고
		ResultSet resultSet = preparedStatement.executeQuery();
		//실행결과를 객체에 매핑하고
		resultSet.next();
		User user = new User();
		user.setId(resultSet.getString("id"));
		user.setName(resultSet.getString("name"));
		user.setPassword(resultSet.getString("password"));
		//자원해제하고
		resultSet.close();
		preparedStatement.close();
		connection.close();
		//매핑된 결과를 리턴한다.
		return user;
	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		//쿼리를 만들고
		String query = "insert into userinfo(id, name, password) values (? , ? , ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getPassword());
		//실행하고
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/jeju?characterEncoding=utf-8", "jeju", "jejupw");
		return connection;
	}

}
