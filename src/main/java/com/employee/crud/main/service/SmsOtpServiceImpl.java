package com.employee.crud.main.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.crud.main.config.TwilioConfig;
import com.employee.crud.main.dto.OTPStatus;
import com.employee.crud.main.request.OTPRequest;
import com.employee.crud.main.request.OTPValidationRequest;
import com.employee.crud.main.response.OTPResponseDto;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsOtpServiceImpl implements SmsOtpService {

	@Autowired
	private TwilioConfig twilioConfig;

	Map<String, String> otpMap = new HashMap<>();

	@Override
	public OTPResponseDto sendSMS(OTPRequest otpRequest) {

		OTPResponseDto otpResponseDto = null;

		try {
			PhoneNumber to = new PhoneNumber(otpRequest.getPhoneNumber());
			PhoneNumber from = new PhoneNumber(twilioConfig.getPhoneNumber());

			String otp = generateOTP();

			String otpMessage = "Dear Customer , Your OTP is " + otp
					+ " for sending sms through spring boot application. Thank You";

			Message message = Message.creator(to, from, otpMessage).create();

			otpMap.put(otpRequest.getUserName(), otp);

			otpResponseDto = new OTPResponseDto(OTPStatus.DELIVERED, otpMessage);
		} catch (Exception e) {

			otpResponseDto = new OTPResponseDto(OTPStatus.FAILED, e.getMessage());
		}

		return otpResponseDto;
	}

	// 6 digits otp
	private String generateOTP() {

		return new DecimalFormat(Pattern.quote("000000")).format(new Random().nextInt(999999));
	}

	@Override
	public String validateOtp(OTPValidationRequest otpValidationRequest) {

		Set<String> keys = otpMap.keySet();
		String username = null;

		for (String key : keys) {
			username = key;
		}

		if (otpValidationRequest.getUserName().equals(username)) {
			otpMap.remove(username, otpValidationRequest.getOtpNumber());
			return "OTP is Valid!";
		} else {
			return "OTP is InValid!";
		}

	}

}
