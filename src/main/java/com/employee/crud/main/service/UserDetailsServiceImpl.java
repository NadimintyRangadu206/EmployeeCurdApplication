package com.employee.crud.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.crud.main.dto.UserInfoUserDetails;
import com.employee.crud.main.entity.UserInfo;
import com.employee.crud.main.repository.UserInfoRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Optional<UserInfo> userInfo=userInfoRepository.findByUserName(username);
		
		return  userInfo.map(UserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found!"));
	}

	
}
