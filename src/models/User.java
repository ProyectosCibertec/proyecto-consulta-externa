package models;

public class User {

	private String code, password, user;
	private int userType;

	public User() {

	}

	public User(String code) {
		this.code = code;
	}

	public User(String code, String password, String user, int userType) {
		this.code = code;
		this.password = password;
		this.user = user;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public void setCode(String code) {
		this.code = code;
		System.out.println("setCode.java-> " + code);
	}

	public String getCode() {
		return code;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
