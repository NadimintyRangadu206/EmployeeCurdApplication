package com.employee.crud.main.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.crud.main.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select e from Employee e ", nativeQuery = false)
	Page<Employee> findByAllEmployees(Pageable paging);

	@Query(value = "select e from Employee e where e.employeeName =?1"
			+ " or e.address=?2 "
			+ "or e.age=?3 "
			+ "or e.companyName=?4"
			+ " or e.dept=?5 "
			+ "or e.salary =?6", 
			nativeQuery = false)
	Page<Employee> findAllSearchByEmployee(Pageable paging, String employeeName, String address, int age,
			String companyName, String dept, double salary);

	@Query(value = "select "
			+ "te.employee_id, te.employee_name,"
			+ "te.address,te.age,te.company_name,"
			+ "te.dept,te.salary from txn_employee te "
			+ "where te.employee_id=?1", nativeQuery = true)
	Optional<Employee> findByEmployeeId(int employeeId);

}
