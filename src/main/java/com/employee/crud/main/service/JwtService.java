package com.employee.crud.main.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {

	public String generateToken(String userName);

	public String extractUserName(String token);

	public  boolean validateToken(String token, UserDetails userDetails);

}
