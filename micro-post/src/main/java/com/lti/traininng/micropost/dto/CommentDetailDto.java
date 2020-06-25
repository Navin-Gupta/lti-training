package com.lti.traininng.micropost.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDetailDto {

	private String commentId;
	private String comment;
	private String tags;
	private UserDetailDto commentedByUser;
	private LocalDateTime commentedOn;
	private Integer likes;
}

