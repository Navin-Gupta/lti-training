package com.lti.training.microuser.service;

import org.springframework.stereotype.Service;

import com.lti.training.microuser.dto.LoginDto;
import com.lti.training.microuser.dto.RegisterDto;
import com.lti.training.microuser.dto.UserDetailDto;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserDetailDto register(RegisterDto registerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetailDto login(LoginDto loginDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkAlreadyInUse(String emailId) {
		// TODO Auto-generated method stub
		return false;
	}

}
