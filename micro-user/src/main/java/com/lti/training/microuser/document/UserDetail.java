package com.lti.training.microuser.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// mapped with mongo db table(document)
@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetail {
	
	@Id
	private String id;
	private String emailId;
	private String password;
	private String firstName;
	private String lastName;
	// private String profilePic;
	
}
