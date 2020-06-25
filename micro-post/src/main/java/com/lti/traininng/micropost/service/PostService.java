package com.lti.traininng.micropost.service;

import com.lti.traininng.micropost.dto.PostDetailDto;
import com.lti.traininng.micropost.dto.PostDetailListDto;
import com.lti.traininng.micropost.dto.PostDto;

public interface PostService {

	public PostDetailDto addPost(PostDto postDto, String userId);
	public PostDetailDto getPost(String postId);
	public Integer addLike(String postId);
	public PostDetailListDto getPosts(String userId);
}