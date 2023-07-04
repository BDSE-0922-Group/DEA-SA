package com.MoW.DEASA.payload;

public class UpdateUser {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userRole;
    
	public UpdateUser() {
	}

	public UpdateUser(String userName, String userEmail, String userPassword, String userRole) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
    
}

