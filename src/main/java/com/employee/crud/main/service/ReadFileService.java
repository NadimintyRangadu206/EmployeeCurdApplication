package com.employee.crud.main.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employee.crud.main.entity.Employee;

@Service
public interface ReadFileService {

	List<Employee> readFile(MultipartFile multipartFile) throws IOException;

}
