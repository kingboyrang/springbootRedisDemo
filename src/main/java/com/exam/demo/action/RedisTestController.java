package com.exam.demo.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redis")
public class RedisTestController {
	
	

	
	@Autowired
	private RedisTemplate<String, Object> template;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getTest() {
		
		ValueOperations<String, Object> redisString = template.opsForValue();
		// SET key value: 设置指定 key 的值
	    redisString.set("strKey1", "hello spring boot redis");
		// GET key: 获取指定 key 的值
		String value = (String) redisString.get("strKey1");
		
		return "hello world "+value;
	}

}
