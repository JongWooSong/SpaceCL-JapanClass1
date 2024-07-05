package com.hello.hellospring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
}
