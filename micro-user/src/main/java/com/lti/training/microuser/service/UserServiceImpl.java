package com.lti.training.microuser.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.training.microuser.controller.dao.UserDetailRepository;
import com.lti.training.microuser.document.UserDetail;
import com.lti.training.microuser.dto.LoginDto;
import com.lti.training.microuser.dto.RegisterDto;
import com.lti.training.microuser.dto.UserDetailDto;

@Service
public class UserServiceImpl implements UserService {

	private UserDetailRepository repository;
	
	public UserServiceImpl(UserDetailRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	
	@Override
	public UserDetailDto register(RegisterDto registerDto) {
		// convert Dto -> Document
		UserDetail userDetail = new UserDetail(null, 
											   registerDto.getEmailId(), 
											   registerDto.getPassword(), 
											   registerDto.getFirstName(), 
											   registerDto.getLastName());
		userDetail = this.repository.save(userDetail);
		// convert Dto -> Document
		UserDetailDto userDetailDto = new UserDetailDto(userDetail.getId(), 
														userDetail.getEmailId(), 
														userDetail.getFirstName(), 
														userDetail.getLastName());
		return userDetailDto;
				
		
	}
	@Override
	public UserDetailDto login(LoginDto loginDto) {
		// TODO Auto-generated method stub
		List<UserDetail> userDetails = this.repository.findByEmailIdAndPassword(loginDto.getLoginId(), loginDto.getPassword());
		if(userDetails.size() > 0) {
			UserDetail userDetail = userDetails.get(0);
			UserDetailDto userDetailDto = new UserDetailDto(userDetail.getId(), 
											userDetail.getEmailId(), 
											userDetail.getFirstName(), 
											userDetail.getLastName());
			return userDetailDto;
		}
		
		return null;
	}

	@Override
	public boolean checkAlreadyInUse(String emailId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDetailDto getUserDetail(String userId) {
		UserDetail userDetail =  this.repository.findById(userId).orElse(null);
		if(userDetail != null) {
			UserDetailDto userDetailDto = new UserDetailDto(userDetail.getId(), 
										userDetail.getEmailId(), 
										userDetail.getFirstName(), 
										userDetail.getLastName());
			return userDetailDto;
		}
		return null;
		
	}

}
