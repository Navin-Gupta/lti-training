package com.lti.traininng.micropost.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString	
public class Post {
	@Id
	private String id;
	private String title;
	private String tags;
	private String post;
	private String userId;
	private LocalDateTime postedOn;
	private Integer likes;
}