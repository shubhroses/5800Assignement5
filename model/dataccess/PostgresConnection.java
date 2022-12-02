package model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection implements DataBaseConnection{

	@Override
	public Connection getDataBaseConnection(String URL, String USER, String PWD)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(URL, USER, PWD);
		return connection;
	}

}
