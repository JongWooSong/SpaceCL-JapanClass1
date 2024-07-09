package com.hello.hellospring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.hellospring.common.Constants;
import com.hello.hellospring.common.bean.MemberBean;
import com.hello.hellospring.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value = "/deleteMemberNew", method = {RequestMethod.POST} )
	@ResponseBody
	public Map<String, Object> deleteMember(@RequestBody MemberBean bean) throws Exception 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String result = Constants.RESULT_VAL_FAIL;
		String resultMsg = "회원정보 삭제에 실패 하였습니다.";
		
		try {
			int res = memberService.deleteMember(bean);
			if( res > 0 ) {
				//성공
				result = Constants.RESULT_VAL_OK;
				resultMsg = "회원정보 삭제에 성공 하였습니다.";
			}
		} catch(Exception e) {
			e.printStackTrace();
			resultMsg = "서버쪽 에러가 발행 했습니다. 관리자에게 문의 하세요";
		}
		
		map.put(Constants.RESULT_KEY, result);
		map.put(Constants.RESULT_KEY_MSG, resultMsg);
		return map;
	}
	
	
	//토큰 발행
	@RequestMapping(value = "/getLoginToken", method = {RequestMethod.POST} )
	@ResponseBody
	public Map<String, Object> getLoginToken(@RequestBody MemberBean bean) throws Exception 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String result = Constants.RESULT_VAL_FAIL;
		String resultMsg = "회원정보 Token 발행에 실패 하였습니다.";
		
		
		return map;
	}
	
	
}
