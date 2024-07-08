package com.hello.hellospring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.hellospring.common.Constants;
import com.hello.hellospring.common.bean.MemberBean;
import com.hello.hellospring.common.daos.MemberDao;

@Controller
public class DaoTestController {

	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value = "/selectMember", method = {RequestMethod.GET} )
	@ResponseBody
	public Map<String, Object> selectMember(MemberBean bean) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		MemberBean resBean = memberDao.selectMember(bean);
		if(resBean != null) {
			map.put("memberBean", resBean);
		} else {
			map.put("memberBean", "존재하지 않는 id 멤버 입니다.");
		}
		
		return map;
	}
	
	
	@RequestMapping(value = "/selectMemberList", method = {RequestMethod.GET} )
	@ResponseBody
	public Map<String, Object> selectMemberList(MemberBean bean) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MemberBean> memberList = memberDao.selectMemberList(bean);
		map.put("memberList", memberList);
		
		return map;
	}
	
	@RequestMapping(value = "/insertMember", method = {RequestMethod.POST} )
	@ResponseBody
	public Map<String, Object> insertMember(@RequestBody MemberBean bean) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//validation 체크
		if(bean.getBirthdate() != null && bean.getBirthdate().length() > 8) {
			map.put(Constants.RESULT_KEY, Constants.RESULT_VAL_FAIL);
			map.put(Constants.RESULT_KEY_MSG, "생년월일이 8글자를 초과할 수 없습니다.");
			return map;
		}
		
		int res = memberDao.insertMember(bean);
		if(res > 0) {
			map.put(Constants.RESULT_KEY, Constants.RESULT_VAL_OK);
			map.put(Constants.RESULT_KEY_MSG, "회원등록에 성공 하였습니다.");
		} else {
			map.put(Constants.RESULT_KEY, Constants.RESULT_VAL_FAIL);
			map.put(Constants.RESULT_KEY_MSG, "회원등록에 실패 하였습니다.");
		}
		
		return map;
	}
	
	
	@RequestMapping(value = "/updateMember", method = {RequestMethod.POST} )
	@ResponseBody
	public Map<String, Object> updateMember(@RequestBody MemberBean bean) throws Exception 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String result = Constants.RESULT_VAL_FAIL;
		String resultMsg = "회원정보 수정에 실패 하였습니다.";
		
		//TODO
		int res = memberDao.updateMember(bean);
		if( res > 0 ) {
			//성공
			result = Constants.RESULT_VAL_OK;
			resultMsg = "회원정보 수정에 성공 하였습니다.";
		}
		
		map.put(Constants.RESULT_KEY, result);
		map.put(Constants.RESULT_KEY_MSG, resultMsg);
		return map;
	}
	
	@RequestMapping(value = "/deleteMember", method = {RequestMethod.POST} )
	@ResponseBody
	public Map<String, Object> deleteMember(@RequestBody MemberBean bean) throws Exception 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String result = Constants.RESULT_VAL_FAIL;
		String resultMsg = "회원정보 삭제에 실패 하였습니다.";
		
		try {
			int res = memberDao.deleteMember(bean);
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
	
}
