package com.hello.HelloSpring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.HelloSpring.bean.MemberBean;

@Controller
public class InputController {

	@RequestMapping(value = "/insertStudent" , method = {RequestMethod.POST}, 
				produces = MediaType.APPLICATION_JSON_VALUE
			)
	@ResponseBody //json 으로 반환하겠다.
	public Map<String, Object> insertStudent(@RequestBody MemberBean bean) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//bean 안에 데이터가 오는지를 보자
		if(bean != null) {
			System.out.println( bean.getName() );
			System.out.println( bean.getAge() );
			System.out.println( bean.getAddress() != null ? bean.getAddress().getCity() : "" );
			System.out.println( bean.isStudent() );
			System.out.println( bean.getLanguages() );
		}
		
		return map;
	}
	
}
