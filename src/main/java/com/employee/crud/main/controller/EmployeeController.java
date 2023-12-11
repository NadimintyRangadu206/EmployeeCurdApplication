  package com.employee.crud.main.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.crud.main.entity.AuthRequest;
import com.employee.crud.main.entity.Employee;
import com.employee.crud.main.exception.EmployeeException;
import com.employee.crud.main.request.EmployeePageResponse;
import com.employee.crud.main.request.EmployeeRequest;
import com.employee.crud.main.request.EmployeeResponse;
import com.employee.crud.main.request.EmployeeSearch;
import com.employee.crud.main.service.EmployeeService;
import com.employee.crud.main.service.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/employee/")
public class EmployeeController {

	private static final Logger logger=LogManager.getLogger(EmployeeController.class);
	
	
	@Autowired
	EmployeeService employeeService;

	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("save")
	public ResponseEntity<String> saveEmployee(@RequestBody @Valid EmployeeRequest request) {

		try {
			Employee employee = employeeService.saveEmployeeInfo(request);
			logger.info("Employee Addeded Succesfully!");

			if (employee != null) {
				return new ResponseEntity<>("Employee Added Successfully", HttpStatus.OK);
			} else {

				return new ResponseEntity<>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (EmployeeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("get/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Employee getEmployeeById(@PathVariable int id) {

		return employeeService.getEmployeeById(id);
	}

	@GetMapping("get/all")
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<Employee> getAllEmloyees() {

		List<Employee> listOfEmployees = employeeService.getAllEmployees();

		return listOfEmployees;
	}

	@PostMapping("update/employee")
	public ResponseEntity<String> updateEmployeeById(@RequestBody EmployeeResponse employeeResponse) {

		Employee emp = employeeService.updateEmployee(employeeResponse);

		if (emp != null) {
			return new ResponseEntity<>("Employee Details are Update!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("delete/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {

		employeeService.deleteEmployee(id);
		if (id != 0) {
			return new ResponseEntity<String>("Employee Details are Deleted Succesfully..", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUserName());
		} else {
			throw new EmployeeException(400, "Invalid User");
		}
	}
	
	
	
	@PostMapping("search/employee")
	public EmployeePageResponse findByAllEmployees(@RequestBody EmployeeSearch employeeSearch){
		
		return employeeService.findByAllEmployees(employeeSearch);
		 
	}
	
	
}
