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
import com.hello.hellospring.common.utils.JwtTokenHelper;
import com.hello.hellospring.service.MemberService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		
		MemberBean resBean = memberService.selectMember(bean);
		//id 로 DB를 조회한 다음 파리미터로 넘어온 패스워드 값과 DB의 PW 값이 일치 하는지를 비교한다.
		if( resBean != null && resBean.getPw().equals( bean.getPw() ) ) {
			//일치 한다면, 인증이 된 유져이다. 토큰을 발행 해준다.
			//토큰의 유효기간 1000 = 1초 ==> 24시간 ==> 86400 * 1000
			long expTime = 86400 * 1000;
			String token = JwtTokenHelper.createJWT(resBean.getId(), resBean.getMemberNo(), 
										resBean.getHp(), expTime);
			map.put("token", token);
			result = Constants.RESULT_VAL_OK;
			resultMsg = "토큰 발행에 성공 하였습니다.";
		}
		
		map.put(Constants.RESULT_KEY, result);
		map.put(Constants.RESULT_KEY_MSG, resultMsg);
		return map;
	}
	
	
	//토큰 검증
	@RequestMapping(value = "/verifyToken", method = {RequestMethod.POST} )
	@ResponseBody
	public Map<String, Object> verifyToken(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String result = Constants.RESULT_VAL_FAIL;
		String resultMsg = "회원정보 Token 검증에 실패 하였습니다.";
		
		//헤더로 부터 넘어온 토큰을 검증한다.
		String authToken = request.getHeader("Authorization");
		System.out.println("authToken:" + authToken);
		
		//토큰이 존재한다면 토큰값이 유효한지를 체크한다.
		if(authToken != null) {
			authToken = authToken.replace("Bearer ", "");
			try {
				Claims claims = JwtTokenHelper.parseClaims(authToken).getBody();
				String id = claims.getId();
				String issuer = claims.getIssuer();
				String subject = claims.getSubject();
				System.out.println("id:" + id + ", isuuer:" + issuer + ", subejct:" + subject);
				result = Constants.RESULT_VAL_OK;
				resultMsg = "회원정보 Token 검증에 성공 하였습니다.";
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		map.put(Constants.RESULT_KEY, result);
		map.put(Constants.RESULT_KEY_MSG, resultMsg);
		return map;
	}//end method
	
}
