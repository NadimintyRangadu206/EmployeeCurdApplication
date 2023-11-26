package com.employee.crud.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.crud.main.entity.UserInfo;
import com.employee.crud.main.service.UserInfoService;

@RestController
@RequestMapping("api/v1/userinfo")
public class UserInfoController {

	@Autowired
	public UserInfoService userinfoService;

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody UserInfo userinfo) {

		ResponseEntity<String> response = null;

		UserInfo userInfo = userinfoService.saveUser(userinfo);

		if (userInfo != null) {
			response = new ResponseEntity<>("User saved Successfully!", HttpStatus.OK);
		} else {
			response = new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}
}
