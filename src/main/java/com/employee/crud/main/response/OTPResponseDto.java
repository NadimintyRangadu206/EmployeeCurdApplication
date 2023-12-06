package com.employee.crud.main.response;

import com.employee.crud.main.dto.OTPStatus;

public class OTPResponseDto {

	private OTPStatus status;
	private String message;

	
	public OTPResponseDto(OTPStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public OTPStatus getStatus() {
		return status;
	}

	public void setStatus(OTPStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OTPResponseDto [status=" + status + ", message=" + message + "]";
	}

}
