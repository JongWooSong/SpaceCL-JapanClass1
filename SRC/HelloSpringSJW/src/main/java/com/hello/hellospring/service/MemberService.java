package com.hello.hellospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hello.hellospring.common.bean.BoardBean;
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
	
	@Transactional(rollbackFor=Exception.class)
	public int deleteMember(MemberBean memberBean) throws Exception {
		int res = 0;
		
		BoardBean boardBean = new BoardBean();
		boardBean.setMemberNo( memberBean.getMemberNo() );
		
		//1.board 테이블에서 삭제
		int delBoradRow = boardDao.deleteBoardFromMemberNo(boardBean);
		
		//2.Member 테이블에서 삭제 
		int delMemRow = memberDao.deleteMember(memberBean);
		
		if(delBoradRow >= 0 && delMemRow > 0) {
			return 1;
		}
		else {
			throw new Exception("멤버 테이블의 멤버가 삭제되지 않았습니다.");	
		}
		
	}
	
}
