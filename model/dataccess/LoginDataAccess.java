package model.dataccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.User;

public class LoginDataAccess{
	
	private static LoginDataAccess instance;

    private LoginDataAccess(){}

    public static LoginDataAccess getInstance() {
        if (instance == null) {
            instance = new LoginDataAccess();
        }
        return instance;
    }
	

	public Boolean verifyCredentials(User user) throws ClassNotFoundException, SQLException {

		final String URL = "jdbc:postgresql://localhost:5432/authentication";
		final String USER = "postgres";
		final String PWD = "123";
		
		DataBaseConnection dataConnection = new PostgresConnection();
		
		Connection connection = dataConnection.getDataBaseConnection(URL, USER, PWD);

		final PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE username=? and password=?");

		stmt.setString(1, user.getUserName());
		stmt.setString(2, user.getPassword());

		ResultSet rs = stmt.executeQuery();

		return rs.next();
		
	}
}

