package com.employee.crud.main.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "txn_Employee")
@Entity

@EntityListeners(AuditingEntityListener.class)
public class Employee extends EntityAudit {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employee_Id")
	private int EmployeeId;

	@Column(name = "Employee_Name")
	private String employeeName;

	@Column(name = "address")
	private String address;

	@Column(name = "age")
	private int age;

	@Column(name = "Company_Name")
	private String companyName;

	@Column(name = "dept")
	private String dept;

	@Column(name = "salary")
	private double salary;

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
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
		return "Employee [EmployeeId=" + EmployeeId + ", employeeName=" + employeeName + ", address=" + address
				+ ", age=" + age + ", companyName=" + companyName + ", dept=" + dept + ", salary=" + salary + "]";
	}

}
