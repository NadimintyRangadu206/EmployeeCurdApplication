package com.employee.crud.main.request;

public class EmployeeRequest {

	private String EmployeeName;

	private String address;

	private int age;

	private String companyName;

	private String dept;

	private double salary;

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
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
		return "EmployeeRequest [EmployeeName=" + EmployeeName + ", address=" + address + ", age=" + age
				+ ", companyName=" + companyName + ", dept=" + dept + ", salary=" + salary + "]";
	}

}
