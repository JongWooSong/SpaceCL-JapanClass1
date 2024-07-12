package com.hello.hellospring.controller;

import java.util.HashMap;
import java.util.List;
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
import com.hello.hellospring.common.bean.MemberBean;
import com.hello.hellospring.service.BoardService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardSerivce;
	
	
	@RequestMapping(value = "/insertBoard" , method = {RequestMethod.POST}, 
			produces = MediaType.APPLICATION_JSON_VALUE
		)
	@ResponseBody //json 으로 반환하겠다.
	public Map<String, Object> insertBoard(@RequestBody BoardBean bean, HttpSession session) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		String result = Constants.RESULT_VAL_FAIL;
		String resultMsg = "게시글 작성에 실패 하였습니다.";
		
		//세션값을 들고온다.
		MemberBean memberBean = (MemberBean) session.getAttribute(Constants.KEY_SESSION_MEMBER_BEAN);
		if(memberBean != null) {
			//토큰값안의 memberNo 값을 가져와서 insert 정보에 넣어준다.
			bean.setMemberNo( memberBean.getMemberNo() );
		}
		
		try {
			int resInt = boardSerivce.insertBoard(bean);
			if(resInt > 0) {
				result = Constants.RESULT_VAL_OK;
				resultMsg = "게시글 작성에 성공 하였습니다.";
			}
		} catch(Exception e) {
			e.printStackTrace();
			resultMsg = "회원정보 입력 데이터가 올바르지 않습니다";
		}
		
		map.put(Constants.RESULT_KEY, result);
		map.put(Constants.RESULT_KEY_MSG, resultMsg);
		return map;
	}
	
	
	@RequestMapping(value = "/selectBoardList", method = {RequestMethod.GET} )
	@ResponseBody
	public Map<String, Object> selectBoardList(BoardBean bean) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		String result = Constants.RESULT_VAL_FAIL;
		String resultMsg = "게시글 목록 조회에 실패 하였습니다.";
		
		List<BoardBean> list = null;
		int totalPage = 0;
		int totalCount = 0;
		try {
			totalCount = boardSerivce.selectBoardListCount(bean);
			totalPage = (int)Math.ceil(totalCount / 10.0);
			
			list = boardSerivce.selecetBoardList(bean);
			result = Constants.RESULT_VAL_OK;
			resultMsg = "게시글 목록 조회에 성공 하였습니다.";
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		map.put(Constants.RESULT_KEY_DATA, list);
		map.put("totalPage", totalPage);
		map.put("totalCount", totalCount);
		
		map.put(Constants.RESULT_KEY, result);
		map.put(Constants.RESULT_KEY_MSG, resultMsg);
		return map;
	}
	
}
