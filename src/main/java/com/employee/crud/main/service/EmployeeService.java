package com.employee.crud.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.crud.main.entity.Employee;
import com.employee.crud.main.request.EmployeeRequest;
import com.employee.crud.main.request.EmployeeResponse;

@Service
public interface EmployeeService {

	Employee saveEmployeeInfo(EmployeeRequest request);

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployees();

	Employee updateEmployee(EmployeeResponse employeeResponse);

	public void deleteEmployee(int id);

}
