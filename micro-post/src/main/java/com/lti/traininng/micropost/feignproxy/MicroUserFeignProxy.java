package com.lti.traininng.micropost.feignproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lti.traininng.micropost.dto.UserDetailDto;



@FeignClient(name="micro-user")
// all requests must be routed through API-GATEWAY
// @FeignClient(name="api-gateway")
@RibbonClient(name="micro-user")
public interface MicroUserFeignProxy {
	@GetMapping("api/user/get/{userId}")
	// @GetMapping("/micro-user/api/user/get/{userId}")
	public ResponseEntity<UserDetailDto> getUserDetail(@PathVariable("userId") String userId);
	// [api-gateway/micro-user/api/user/get/{userId}]
}
