package com.lti.traininng.micropost.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lti.traininng.micropost.dao.PostRepository;
import com.lti.traininng.micropost.document.Post;
import com.lti.traininng.micropost.dto.PostDetailDto;
import com.lti.traininng.micropost.dto.PostDetailListDto;
import com.lti.traininng.micropost.dto.PostDto;
import com.lti.traininng.micropost.dto.UserDetailDto;
import com.lti.traininng.micropost.feignproxy.MicroUserFeignProxy;

@Service
public class PostServiceImpl implements PostService{

	private static String USER_URL = "http://localhost:6060/api/user";
	
	private PostRepository repository;
	// private RestTemplate restTemplate;
	private MicroUserFeignProxy proxy;
	
	
	public PostServiceImpl(PostRepository repository,
							// RestTemplate restTemplate,
							MicroUserFeignProxy proxy) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
		// this.restTemplate = restTemplate;
		this.proxy = proxy;
	}
	
	
	@Override
	public PostDetailDto addPost(PostDto postDto, String userId) {
		// TODO Auto-generated method stub
		// Dto->Document
		Post postDb = new Post(null, 
							   postDto.getTitle(), 
							   postDto.getTags(), 
							   postDto.getPost(), 
							   userId, 
							   LocalDateTime.now(), 
							   0);
		postDb = this.repository.save(postDb);
		// UserDetailDto userDetailDto = this.restTemplate.getForObject(USER_URL + "/get/" + userId, UserDetailDto.class);
		UserDetailDto userDetailDto = this.proxy.getUserDetail(userId).getBody();
		
		PostDetailDto postDetailDto = new PostDetailDto(postDb.getId(), 
														postDb.getTitle(), 
														postDb.getTags(), 
														postDb.getPost(), 
														userDetailDto, 
														postDb.getPostedOn(), 
														postDb.getLikes());
		
				
		return postDetailDto;
	}

	@Override
	public PostDetailDto getPost(String postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer addLike(String postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDetailListDto getPosts(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
