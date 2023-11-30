package com.employee.crud.main.request;

import java.util.List;

import com.employee.crud.main.entity.Employee;

public class EmployeePageResponse {

	private long count;
	private List<Employee> listOfEmployees;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}

	@Override
	public String toString() {
		return "EmployeePageResponse [count=" + count + ", listOfEmployees=" + listOfEmployees + "]";
	}

}
