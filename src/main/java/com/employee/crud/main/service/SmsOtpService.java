package com.employee.crud.main.service;

import org.springframework.stereotype.Service;

import com.employee.crud.main.request.OTPRequest;
import com.employee.crud.main.request.OTPValidationRequest;
import com.employee.crud.main.response.OTPResponseDto;

@Service
public interface SmsOtpService {

	OTPResponseDto sendSMS(OTPRequest otpRequest);

	String validateOtp(OTPValidationRequest otpValidationRequest);

}
