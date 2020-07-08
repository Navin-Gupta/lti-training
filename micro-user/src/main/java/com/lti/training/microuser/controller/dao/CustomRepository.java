package com.lti.training.microuser.controller.dao;

import java.util.List;

import com.lti.training.microuser.document.UserDetail;

public interface CustomRepository {

	List<UserDetail> complexLogic(String firstName, String emailId);
	
}
