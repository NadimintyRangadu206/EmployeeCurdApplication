package com.employee.crud.main.exception;

public class EmployeeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int errorCode;
	private Exception exception;

	public EmployeeException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;

	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	@Override
	public String toString() {
		return "EmployeeException [errorCode=" + errorCode + ", exception=" + exception + "]";
	}

}
