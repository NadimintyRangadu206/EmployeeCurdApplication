package com.employee.crud.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.crud.main.request.OTPRequest;
import com.employee.crud.main.request.OTPValidationRequest;
import com.employee.crud.main.response.OTPResponseDto;
import com.employee.crud.main.service.SmsOtpService;

@RestController
@RequestMapping("api/v1/otp/")
public class OTPController {

	@Autowired
	private SmsOtpService otpService;
	
	@GetMapping("set/proces")
	public String getProcess() {
		return "Sms send!";
	}

	@PostMapping("send/otp")
	public OTPResponseDto sendOtp(@RequestBody OTPRequest otpRequest) {

		return otpService.sendSMS(otpRequest);
	}

	@PostMapping("validate/otp")
	public String validateOtp(@RequestBody OTPValidationRequest otpValidationRequest) {
		
		return otpService.validateOtp(otpValidationRequest);
		
	}
}
