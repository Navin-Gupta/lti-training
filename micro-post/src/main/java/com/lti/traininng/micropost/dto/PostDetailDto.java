package com.lti.traininng.micropost.dto;

import java.time.LocalDateTime;
import java.util.List;

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
public class PostDetailDto {
	private String postId;
	private String title;
	private String tags;
	private String post;
	private UserDetailDto postedByUser;
	private LocalDateTime postedOn;
	private Integer likes;
	// private List<CommentDetailDto> comments;
}

