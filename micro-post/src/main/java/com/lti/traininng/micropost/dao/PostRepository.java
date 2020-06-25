package com.lti.traininng.micropost.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.traininng.micropost.document.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, String>{

}
