package com.employee.crud.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.crud.main.entity.UserInfo;
import com.employee.crud.main.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoRepository userinfoRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public UserInfo saveUser(UserInfo userInfo) {

		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

		return userinfoRepository.save(userInfo);
	}

}
