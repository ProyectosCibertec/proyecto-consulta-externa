package models;

public class newUser {

	String userPersonal, newUser, newPassword;
	int userCode, userType;

	public newUser() {
	}

	public newUser(String userPersonal, int userCode, String newUser, String newPassword, int userType) {
		this.userPersonal = userPersonal;
		this.newUser = newUser;
		this.newPassword = newPassword;
		this.userCode = userCode;
		this.userType = userType;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getUserPersonal() {
		return userPersonal;
	}

	public void setUserPersonal(String userPersonal) {
		this.userPersonal = userPersonal;
	}

	public String getNewUser() {
		return newUser;
	}

	public void setNewUser(String newUser) {
		this.newUser = newUser;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

}
