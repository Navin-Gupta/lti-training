package com.lti.training.microuser.service;

import com.lti.training.microuser.dto.LoginDto;
import com.lti.training.microuser.dto.RegisterDto;
import com.lti.training.microuser.dto.UserDetailDto;

public interface UserService {
	public UserDetailDto register(RegisterDto registerDto);
	public UserDetailDto login(LoginDto loginDto);
	public boolean checkAlreadyInUse(String emailId);
	
}
