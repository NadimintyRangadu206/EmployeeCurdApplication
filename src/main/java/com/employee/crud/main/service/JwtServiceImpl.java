package com.employee.crud.main.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl implements JwtService {

	@Override
	public String generateToken(String userName) {

		Map<String, String> claims = new HashMap<>();

		return createToken(claims, userName);
	}

	private String createToken(Map<String, String> claims, String userName) {

		return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
				.signWith(getSecKey(), SignatureAlgorithm.HS256).compact();

	}

	private Key getSecKey() {

		byte[] keyBytes = Decoders.BASE64.decode("5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437");

		return Keys.hmacShaKeyFor(keyBytes);
	}

	@Override
	public String extractUserName(String token) {
		
		return extractClaimFromToken(token, Claims::getSubject);
	}
	
	public <T> T extractClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
private Claims extractAllClaimsFromToken(String token) {
		
           return Jwts
        		   .parserBuilder()
        		   .setSigningKey(getSecKey())
        		   .build()
        		   .parseClaimsJws(token)
        		   .getBody();
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUserName(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public Date getExpirationDateFromToken(String token) {
		return extractClaimFromToken(token, Claims::getExpiration);
	}

}
