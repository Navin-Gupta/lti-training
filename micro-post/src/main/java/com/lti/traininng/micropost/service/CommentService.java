package com.lti.traininng.micropost.service;

import java.util.List;

import com.lti.traininng.micropost.dto.CommentDetailDto;
import com.lti.traininng.micropost.dto.CommentDto;

public interface CommentService {
	public CommentDetailDto addComment(CommentDto comment, String postId, String userId);
	public CommentDetailDto getComment(String commentId);
	public Integer addLike(String commentId);
	public List<CommentDetailDto> getComments(String postId);
}
