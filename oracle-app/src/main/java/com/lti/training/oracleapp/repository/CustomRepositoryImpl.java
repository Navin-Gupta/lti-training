package com.lti.training.oracleapp.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomRepositoryImpl implements CustomRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void complexLogic() {
		// TODO Auto-generated method stub
		// Hibernate
		// Session session = entityManager.unwrap(Session.class);
		// JPA native methods
		
	}

}
