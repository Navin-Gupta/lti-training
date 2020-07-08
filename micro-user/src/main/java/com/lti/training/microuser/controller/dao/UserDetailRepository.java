package com.lti.training.microuser.controller.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.training.microuser.document.UserDetail;

// 1. Document/Entity/Table
// 2. Datatype of PK
// using CrudRepository/JpaRepository : custom queries needs to be defined using JPQL / HQL
// use Mongo style of query : MongoRepository
@Repository
// public interface UserDetailRepository extends CrudRepository<UserDetail, String>{
public interface UserDetailRepository 
			extends MongoRepository<UserDetail, String>, CustomRepository{
	List<UserDetail> findByEmailIdAndPassword(String emailId, String password);
	List<UserDetail> findByEmailId(String emailId);
	// @Query("from UserDetail where firstName:=?) // JPQL
	// List<UserDetail> findByFirstName(String firstName);
	@Query("{firstName : '?0'}")
	List<UserDetail> fun(String firstName);
}
