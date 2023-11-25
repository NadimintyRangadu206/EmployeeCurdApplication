package com.employee.crud.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employee.crud.main.entity.Employee;
import com.employee.crud.main.service.ReadFileService;

@RestController
@RequestMapping("api/v1/file")
public class ReadFileController {

	@Autowired
	public ReadFileService fileService;

	@PostMapping(value = "read", consumes = { org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE,
			org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE })

	public ResponseEntity<String> readFile(@RequestParam("multipartFile") MultipartFile multipartFile) throws IOException {

		ResponseEntity<String> responseEntity = null;

		List<Employee> list = fileService.readFile(multipartFile);

		if (list != null) {
			responseEntity = new ResponseEntity<>("Records are inserted!", HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<>("Somthing went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;

	}
}
