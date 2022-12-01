package businesslayer;

import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;
import java.sql.SQLException;

public class LoginBusiness {
	public static boolean verifyUser(String userName, String password) 
			throws MessageException, SQLException, ClassNotFoundException{
		if (userName.equals("")) {
			throw new MessageException("Username not informed.");
		} else if (password.equals("")) {
			throw new MessageException("Password not informed.");
		} 
		
		User user = new User(userName, password);
			
		if (!(new LoginDataAccess().verifyCredentials(user))) {
			return false;
		} 
		return true;
	}
}
