package com.lti.training.microuser.dto;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class LoginDto {
	private String loginId;
	@Length(min = 6)
	private String password;
}
