package com.employee.crud.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.crud.main.entity.Employee;
import com.employee.crud.main.request.EmployeeRequest;
import com.employee.crud.main.service.EmployeeService;

@RestController
@RequestMapping("api/v1/employee/")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("save")
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeRequest request) {

		Employee employee = employeeService.saveEmployeeInfo(request);

		if (employee != null) {
			return new ResponseEntity<>("Employee Added Successfully", HttpStatus.OK);
		} else {

			return new ResponseEntity<>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("get/{id}")
	public Employee getEmployeeById(@PathVariable int id) {

		return employeeService.getEmployeeById(id);
	}

	@GetMapping("get/all")
	public List<Employee> getAllEmloyees() {

		List<Employee> listOfEmployees = employeeService.getAllEmployees();

		return listOfEmployees;
	}
}
