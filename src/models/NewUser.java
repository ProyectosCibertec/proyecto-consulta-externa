package models;

public class NewUser {

	String userPersonal, userCode, newPassword, dateCreation;
	int userType;

	public NewUser() {
	}

	public NewUser(String userPersonal, String userCode, String newPassword, int userType, String dateCreation) {
		this.userPersonal = userPersonal;
		this.newPassword = newPassword;
		this.userCode = userCode;
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getUserPersonal() {
		return userPersonal;
	}

	public void setUserPersonal(String userPersonal) {
		this.userPersonal = userPersonal;
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
