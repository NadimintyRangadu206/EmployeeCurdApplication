package com.employee.crud.main.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EmployeeRequest {

	private int employeeId;
	
	@NotNull(message = "Please Provide Employee Name")
	@NotEmpty(message = "Employee Name is Not Empty")
	private String employeeName;
	
	@NotNull(message = "Please Provide address")
	@NotEmpty(message = "Employee Name is Not Empty")
	private String address;
	
	@Min(value = 18)
	@Max(value = 60)
	private int age;
	
	@NotNull(message = "Please Provide companyName ")
	@NotEmpty(message = "Employee Name is Not Empty")
	private String companyName;
	
	@NotNull(message = "Please Provide dept")
	@NotEmpty(message = "Employee Name is Not Empty")
	
	private String dept;

	private double salary;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [EmployeeId=" + employeeId + ", employeeName=" + employeeName + ", address=" + address
				+ ", age=" + age + ", companyName=" + companyName + ", dept=" + dept + ", salary=" + salary + "]";
	}

}
