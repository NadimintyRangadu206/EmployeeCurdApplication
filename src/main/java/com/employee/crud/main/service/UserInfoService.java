package com.employee.crud.main.service;

import org.springframework.stereotype.Service;

import com.employee.crud.main.entity.UserInfo;

@Service
public interface UserInfoService {

	UserInfo saveUser(UserInfo userinfo);

}
