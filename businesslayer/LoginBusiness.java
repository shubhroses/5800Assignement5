package businesslayer;

import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;
import java.sql.SQLException;

public class LoginBusiness {
	private static LoginBusiness instance;
	
	private String userName;
	private String password;
	
	private LoginBusiness(){}
	
	public static LoginBusiness getInstance() {
        if (instance == null) {
            instance = new LoginBusiness();
        }
        return instance;
    }
	
	public boolean verifyUser(String userName, String password) 
			throws MessageException, SQLException, ClassNotFoundException{
		if (userName.equals("")) {
			throw new MessageException("Username not informed.");
		} else if (password.equals("")) {
			throw new MessageException("Password not informed.");
		} 
		
		User user = User.getInstance(userName, password);
		//User user = new User(userName, password);
		
		LoginDataAccess instance = LoginDataAccess.getInstance();
			
		if (!(instance.verifyCredentials(user))) {
			return false;
		} 
		return true;
	}
}
