package com.employee.crud.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.crud.main.entity.Employee;
import com.employee.crud.main.repository.EmployeeRepository;
import com.employee.crud.main.request.EmployeeRequest;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployeeInfo(EmployeeRequest request) {

		Employee employee = new Employee();

		employee.setEmployeeName(request.getEmployeeName());
		employee.setAddress(request.getAddress());
		employee.setAge(request.getAge());
		employee.setCompanyName(request.getCompanyName());
		employee.setDept(request.getDept());
		employee.setSalary(request.getSalary());

		return employeeRepository.save(employee);
	}

}
