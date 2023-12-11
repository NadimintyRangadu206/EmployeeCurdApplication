package com.employee.crud.main.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.employee.crud.main.entity.Employee;
import com.employee.crud.main.exception.EmployeeException;
import com.employee.crud.main.repository.EmployeeRepository;
import com.employee.crud.main.request.EmployeePageResponse;
import com.employee.crud.main.request.EmployeeRequest;
import com.employee.crud.main.request.EmployeeResponse;
import com.employee.crud.main.request.EmployeeSearch;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger=LogManager.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployeeInfo(EmployeeRequest request) {

//		validateEmployeeInfo(request);

		Employee employee = null;

		Optional<Employee> optionalId = employeeRepository.findByEmployeeId(request.getEmployeeId());

		if (optionalId.isPresent()) {
			employee = optionalId.get();
		} else {
			employee = new Employee();
		}
		BeanUtils.copyProperties(request, employee);

//		employee.setEmployeeName(request.getEmployeeName());
//		employee.setAddress(request.getAddress());
//		employee.setAge(request.getAge());
//		employee.setCompanyName(request.getCompanyName());
//		employee.setDept(request.getDept());
//		employee.setSalary(request.getSalary());

		return employeeRepository.save(employee);
	}

//	private void validateEmployeeInfo(EmployeeRequest request) {
//
//		if(request.getEmployeeName()==null || request.getEmployeeName().trim().isEmpty()) {
//			
//			throw new EmployeeException(400, "Please Provide Employee Name Here");
//		}
//		
//		if((request.getAge()>=18 && request.getAge()<=60)|| (request.getAge()==0) ) {
//			throw new EmployeeException(400, "Age range(18-60) Please Check!");
//		}
//		
//	}

	@Override
	public Employee getEmployeeById(int id) {

		Optional<Employee> optionalEmployee = employeeRepository.findById(id);

		Employee emp = new Employee();

		if (optionalEmployee.isPresent()) {

			emp = optionalEmployee.get();
		} else {
			try {
				throw new EmployeeException(400, optionalEmployee.orElseThrow().toString());
			} catch (Exception e) {
				logger.info("Employee Id is Not Present");
			}
		}
		return emp;

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

	@Override
	public EmployeePageResponse findByAllEmployees(EmployeeSearch employeeSearch) {

		EmployeePageResponse employeePageResponse = new EmployeePageResponse();

		Pageable paging = PageRequest.of(employeeSearch.getPage() - 1, employeeSearch.getLimit(),
				Sort.by(Sort.Direction.fromString(employeeSearch.getOrderDirection()), employeeSearch.getOrderBy()));
		if (employeeSearch.getEmployeeName().isEmpty() && employeeSearch.getAddress().isEmpty()
				&& employeeSearch.getAge() == 0 && employeeSearch.getCompanyName().isEmpty()
				&& employeeSearch.getDept().isEmpty() && employeeSearch.getSalary() == 0) {

			Page<Employee> employeeList = employeeRepository.findByAllEmployees(paging);

			employeePageResponse.setCount(employeeList.getSize());
			employeePageResponse.setListOfEmployees(employeeList.getContent());
		} else {

			Page<Employee> employeeList = employeeRepository.findAllSearchByEmployee(paging,
					employeeSearch.getEmployeeName(), employeeSearch.getAddress(), employeeSearch.getAge(),
					employeeSearch.getCompanyName(), employeeSearch.getDept(), employeeSearch.getSalary());

			employeePageResponse.setCount(employeeList.getSize());
			employeePageResponse.setListOfEmployees(employeeList.getContent());
		}

		return employeePageResponse;
	}

}
