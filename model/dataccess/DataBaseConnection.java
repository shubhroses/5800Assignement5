package model.dataccess;
import java.sql.Connection;
import java.sql.SQLException;

public interface DataBaseConnection {
	public Connection getDataBaseConnection(String URL, String USER, String PWD) throws ClassNotFoundException, SQLException;
}
