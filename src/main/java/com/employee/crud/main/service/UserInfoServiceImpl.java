package com.employee.crud.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.crud.main.entity.UserInfo;
import com.employee.crud.main.exception.EmployeeException;
import com.employee.crud.main.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoRepository userinfoRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	boolean flag ;
	public UserInfo saveUser(UserInfo userInfo) {
		
		List<UserInfo> listOfUsers=userinfoRepository.findAll();
		
		
		if(null!=listOfUsers) {
			for(UserInfo user:listOfUsers) {
				
				if(user.getUserName().equals(userInfo.getUserName())) 
					flag=true;
				else 
					flag=false;
				
			}
		}
		if(flag!=false) {
		    System.out.println("User Already Exist ");
		    return null;
		}else {

		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

		return userinfoRepository.save(userInfo);
		}
	}

}
