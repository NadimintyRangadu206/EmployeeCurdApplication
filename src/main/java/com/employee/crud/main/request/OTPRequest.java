package com.employee.crud.main.request;

public class OTPRequest {

	private String userName;
	private String phoneNumber;
	private String oneTimePassword;

	public String getOneTimePassword() {
		return oneTimePassword;
	}

	public void setOneTimePassword(String oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "OTPRequest [userName=" + userName + ", phoneNumber=" + phoneNumber + ", oneTimePassword="
				+ oneTimePassword + "]";
	}

}
