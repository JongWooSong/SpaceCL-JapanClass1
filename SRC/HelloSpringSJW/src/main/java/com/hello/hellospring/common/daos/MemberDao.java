package com.hello.hellospring.common.daos;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hello.hellospring.common.bean.MemberBean;

@Mapper
public interface MemberDao {

	//1건 조회 r
	public MemberBean selectMember(MemberBean bean);

	//여러건 조회 r
	public List<MemberBean> selectMemberList(MemberBean bean);

	//1건 입력 c
	public int insertMember(MemberBean bean);
	
	//1건 수정 u
	public int updateMember(MemberBean bean);
	
	//1건 삭제 d
	public int deleteMember(MemberBean bean);
	
}
