package com.lti.training.microuser.controller.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.lti.training.microuser.document.UserDetail;
import com.mongodb.client.result.UpdateResult;

@Component
public class CustomRepositoryImpl implements CustomRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	// update firtName of user having the emailId passed as argument
	@Override
	public List<UserDetail> complexLogic(String firstName, String emailId) {
		// TODO Auto-generated method stub
		Query query = new Query(Criteria.where("emailId").is(emailId));
		Update update = new Update();
		update.set("firstName", firstName);
		UpdateResult result =  this.mongoTemplate.updateFirst(query, update, UserDetail.class);
		result.getMatchedCount(); // how many documents matched this criteria
		result.getModifiedCount(); // how many documents modified by the query
		result.getUpsertedId(); // Id's of documents being updated
		// add code to fetch records
		
		return null;
	}

}
