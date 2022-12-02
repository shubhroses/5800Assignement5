package model.entities;

public class User {
	
	private String userName;
	
	private String password;
	
	private static User instance;
    
    public static User getInstance(String userName, String password){
        if (instance == null) {
            instance = new User(userName, password);
        }
        return instance;
    }
	
	private User (String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
