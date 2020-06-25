package com.lti.traininng.micropost.feignproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lti.traininng.micropost.dto.UserDetailDto;



@FeignClient(name="micro-user")
@RibbonClient(name="micro-user")
public interface MicroUserFeignProxy {
	@GetMapping("api/user/get/{userId}")
	public ResponseEntity<UserDetailDto> getUserDetail(@PathVariable("userId") String userId);
}
