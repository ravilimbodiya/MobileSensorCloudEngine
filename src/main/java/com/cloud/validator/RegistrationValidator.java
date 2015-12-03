package com.cloud.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegistrationValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "",	"First Name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName","", 	"Last Name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", 	"Password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "",	"Email is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNum", "", 	"Phone Number is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userType", "",	"Please select one option.");
	}

}
