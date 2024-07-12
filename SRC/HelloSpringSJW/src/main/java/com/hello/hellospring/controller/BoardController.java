package com.hello.hellospring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.hellospring.common.Constants;
import com.hello.hellospring.common.bean.BoardBean;
import com.hello.hellospring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardSerivce;
	
	
	@RequestMapping(value = "/insertBoard" , method = {RequestMethod.POST}, 
			produces = MediaType.APPLICATION_JSON_VALUE
		)
	@ResponseBody //json 으로 반환하겠다.
	public Map<String, Object> insertBoard(@RequestBody BoardBean bean) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		String result = Constants.RESULT_VAL_FAIL;
		String resultMsg = "게시글 작성에 실패 하였습니다.";
		
		int resInt = boardSerivce.insertBoard(bean);
		if(resInt > 0) {
			result = Constants.RESULT_VAL_OK;
			resultMsg = "게시글 작성에 성공 하였습니다.";
		}
		
		map.put(Constants.RESULT_KEY, result);
		map.put(Constants.RESULT_KEY_MSG, resultMsg);
		return map;
	}
	
}
