package com.employee.crud.main.request;

public class EmployeeSearch {

	private String employeeName;
	private String address;
	private int age;
	private String companyName;
	private String dept;
	private double salary;
	private int limit;
	private int page;
	private String orderBy;
	private String orderDirection;
	private int DEFAULT_SIZE = 5;
	private String DEFAULT_ORDER_BY = "employeeName";
	private String DEFAULT_ORDER_DIRECTION = "ASC";

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

	public int getLimit() {

		if (limit == 0) {
			limit = DEFAULT_SIZE;
		}
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getOrderBy() {

		if (orderBy == null || orderBy.isEmpty()) {
			orderBy = DEFAULT_ORDER_BY;
		}
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderDirection() {

		if (orderDirection == null || orderDirection.isEmpty()) {
			orderDirection = DEFAULT_ORDER_DIRECTION;
		}
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	@Override
	public String toString() {
		return "EmployeeSearch [employeeName=" + employeeName + ", address=" + address + ", age=" + age
				+ ", companyName=" + companyName + ", dept=" + dept + ", salary=" + salary + ", limit=" + limit
				+ ", page=" + page + ", orderBy=" + orderBy + ", orderDirection=" + orderDirection + ", DEFAULT_SIZE="
				+ DEFAULT_SIZE + ", DEFAULT_ORDER_BY=" + DEFAULT_ORDER_BY + ", DEFAULT_ORDER_DIRECTION="
				+ DEFAULT_ORDER_DIRECTION + "]";
	}

}
