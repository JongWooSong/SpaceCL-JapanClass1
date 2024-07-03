package com.hello.HelloSpring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

	@RequestMapping(value = "/firstHello", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> firstHello() throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", "홍길동");
		map.put("age", "19");
		map.put("address", "서울시");
		
		return map;
	}
	
}
