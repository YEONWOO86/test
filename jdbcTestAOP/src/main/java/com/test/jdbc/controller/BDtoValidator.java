package com.test.jdbc.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.test.jdbc.dto.BDto;

public class BDtoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bName", "required",
				new Object[] {"bName"} ,"enter your name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bTitle", "required",
				new Object[] {"bTitle"} ,"enter your title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bContent", "required",
				new Object[] {"bContent"} ,"enter your content");

	}

}
