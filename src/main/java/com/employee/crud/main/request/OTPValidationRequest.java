package com.employee.crud.main.request;

public class OTPValidationRequest {

	private String userName;
	private String otpNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOtpNumber() {
		return otpNumber;
	}

	public void setOtpNumber(String otpNumber) {
		this.otpNumber = otpNumber;
	}

	@Override
	public String toString() {
		return "OTPValidationRequest [userName=" + userName + ", otpNumber=" + otpNumber + "]";
	}

}
