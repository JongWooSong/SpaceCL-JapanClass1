package com.hello.hellospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.hellospring.common.bean.MemberBean;
import com.hello.hellospring.common.daos.BoardDao;
import com.hello.hellospring.common.daos.MemberDao;

//서비스가 하는일은?
//서비스는 여러개의 DAO 객체를 관리해서 일을 수행하는 클래스이다.
@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BoardDao boardDao;
	
	
	public int deleteMember(MemberBean memberBean) throws Exception {
		int res = 0;
		
		//1.board 테이블에서 삭제
		//boardDao.deleteBoard()
		
		//2.Member 테이블에서 삭제 
		//memberDao.deleteMember()
		
		return res;
	}
	
}
