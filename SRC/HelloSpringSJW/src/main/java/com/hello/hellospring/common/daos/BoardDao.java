package com.hello.hellospring.common.daos;

import org.apache.ibatis.annotations.Mapper;

import com.hello.hellospring.common.bean.BoardBean;

@Mapper
public interface BoardDao {

	public int deleteBoardFromMemberNo(BoardBean boardBean);
	
}
