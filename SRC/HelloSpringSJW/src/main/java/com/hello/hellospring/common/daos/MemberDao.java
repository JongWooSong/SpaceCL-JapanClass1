package com.hello.hellospring.common.daos;

import org.apache.ibatis.annotations.Mapper;

import com.hello.hellospring.common.bean.MemberBean;

@Mapper
public interface MemberDao {

	//1건 조회
	public MemberBean selectMember(MemberBean bean);
	
}
