package com.lti.training.microuser.controller.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.training.microuser.document.UserDetail;

// 1. Document/Entity/Table
// 2. Datatype of PK
@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail, String>{
	List<UserDetail> findByEmailIdAndPassword(String emailId, String password);
	List<UserDetail> findByEmailId(String emailId);
}
