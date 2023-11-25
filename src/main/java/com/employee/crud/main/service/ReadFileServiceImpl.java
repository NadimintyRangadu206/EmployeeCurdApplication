package com.employee.crud.main.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employee.crud.main.entity.Employee;
import com.employee.crud.main.repository.EmployeeRepository;

@Service
public class ReadFileServiceImpl implements ReadFileService {

	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public List<Employee> readFile(MultipartFile multipartFile) throws IOException {

		List<Employee> listOfEmployee = new ArrayList<Employee>();

		InputStream is = multipartFile.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		CSVParser csvParser = new CSVParser(br, CSVFormat.DEFAULT);

		Iterable<CSVRecord> iterable = csvParser.getRecords();
		int i = 1;

		for (CSVRecord csvRecord : iterable) {

			if (i == 1) {
				i++;
				continue;
			}

			Employee employee = new Employee();
			employee.setEmployeeName(csvRecord.get(0));
			employee.setAddress(csvRecord.get(1));
			employee.setAge(Integer.parseInt(csvRecord.get(2)));
			employee.setCompanyName(csvRecord.get(3));
			employee.setDept(csvRecord.get(4));
			employee.setSalary(Double.parseDouble(csvRecord.get(5)));

			listOfEmployee.add(employee);

		}

		if (listOfEmployee != null) {
			listOfEmployee = employeeRepository.saveAll(listOfEmployee);
		}
		is.close();
		br.close();

		return listOfEmployee;
	}

}
