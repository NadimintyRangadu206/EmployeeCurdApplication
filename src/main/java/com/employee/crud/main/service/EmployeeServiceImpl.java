package com.employee.crud.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.crud.main.entity.Employee;
import com.employee.crud.main.exception.EmployeeException;
import com.employee.crud.main.repository.EmployeeRepository;
import com.employee.crud.main.request.EmployeeRequest;
import com.employee.crud.main.request.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployeeInfo(EmployeeRequest request) {

		validateEmployeeInfo(request);
		
		Employee employee = new Employee();

		employee.setEmployeeName(request.getEmployeeName());
		employee.setAddress(request.getAddress());
		employee.setAge(request.getAge());
		employee.setCompanyName(request.getCompanyName());
		employee.setDept(request.getDept());
		employee.setSalary(request.getSalary());

		return employeeRepository.save(employee);
	}

	private void validateEmployeeInfo(EmployeeRequest request) {

		if(request.getEmployeeName()==null || request.getEmployeeName().trim().isEmpty()) {
			
			throw new EmployeeException(400, "Please Provide Employee Name Here");
		}
		
		if((request.getAge()>=18 && request.getAge()<=60)|| (request.getAge()==0) ) {
			throw new EmployeeException(400, "Age range(18-60) Please Check!");
		}
		
	}

	@Override
	public Employee getEmployeeById(int id) {

		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}

	}

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> listOfEmployees = employeeRepository.findAll();
		return listOfEmployees;
	}

	@Override
	public Employee updateEmployee(EmployeeResponse employeeResponse) {

		Employee emp = new Employee();

		if (employeeResponse.getEmployeeId() != 0) {

			Optional<Employee> optional = employeeRepository.findById(employeeResponse.getEmployeeId());

			if (optional.isPresent()) {
				emp = optional.get();
			} else {
				emp = new Employee();
			}

		}
		BeanUtils.copyProperties(employeeResponse, emp);
		return employeeRepository.saveAndFlush(emp);
	}

	@Override
	public void deleteEmployee(int id) {

 		employeeRepository.deleteById(id);
		
	}

}
