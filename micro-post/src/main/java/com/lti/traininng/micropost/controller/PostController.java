package com.lti.traininng.micropost.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.traininng.micropost.dto.PostDetailDto;
import com.lti.traininng.micropost.dto.PostDto;
import com.lti.traininng.micropost.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	private PostService service;
	
	public PostController(PostService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	
	// request method to add new post
	@PostMapping("/add/{userId}")
	public ResponseEntity<PostDetailDto> addPost(@PathVariable("userId") String userId,
												 @RequestBody PostDto postDto){
		// add validation check
		PostDetailDto postDetailDto = this.service.addPost(postDto, userId);
		ResponseEntity<PostDetailDto> response = 
				new ResponseEntity<PostDetailDto>(postDetailDto, HttpStatus.OK);
		return response;
	}
}
