package com.lti.training.microuser.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.microuser.dto.LoginDto;
import com.lti.training.microuser.dto.RegisterDto;
import com.lti.training.microuser.dto.UserDetailDto;
import com.lti.training.microuser.dto.UserExceptionDto;
import com.lti.training.microuser.exception.BoundaryException;
import com.lti.training.microuser.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		// TODO Auto-generated constructor stub
		this.userService = userService;
	}

	@PostMapping("/register")
	// recieve DTO (register)
	// return DTO (user details)
	public ResponseEntity<UserDetailDto> register(@RequestBody RegisterDto registerDto) {
		UserDetailDto userDetailDto = this.userService.register(registerDto);
		ResponseEntity<UserDetailDto> response = 
				new ResponseEntity<UserDetailDto>(userDetailDto,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDetailDto> login(@Valid @RequestBody LoginDto loginDto
												, BindingResult result){
		
		if(result.hasErrors()) {
			throw new BoundaryException("Password not in correct format!!!");
		}
		UserDetailDto userDetailDto =  this.userService.login(loginDto);
		ResponseEntity<UserDetailDto> response = 
				new ResponseEntity<UserDetailDto>(userDetailDto,HttpStatus.OK);
		return response;
	}
	
	@ExceptionHandler(BoundaryException.class)
	public ResponseEntity<UserExceptionDto> boundaryExceptionHanler(BoundaryException ex) {
		UserExceptionDto userExceptionDto = 
				new UserExceptionDto(ex.getMessage(), 
									HttpStatus.BAD_REQUEST.value(), 
									System.currentTimeMillis());
		ResponseEntity<UserExceptionDto> response = 
				new ResponseEntity<UserExceptionDto>(userExceptionDto, HttpStatus.BAD_REQUEST);
		return response;
	}
}













