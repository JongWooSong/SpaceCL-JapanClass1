package com.hello.hellospring.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hello.hellospring.common.Constants;
import com.hello.hellospring.common.utils.JwtTokenHelper;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 토큰 체크 인터셉터
 */
public class TokenCheckInterceptor implements HandlerInterceptor {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
		System.out.println("TokenInterceptor preHandle() ===>" + request.getRequestURL());
		
		String result = Constants.RESULT_VAL_FAIL;
		String resultMsg = "회원정보 Token 검증에 실패 하였습니다.";
		
		//정상적인 토큰이 왔는지를 체크한다.
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
		
		
		
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception 
	{
		System.out.println("TokenInterceptor postHandle() <===");
	}
	
}
