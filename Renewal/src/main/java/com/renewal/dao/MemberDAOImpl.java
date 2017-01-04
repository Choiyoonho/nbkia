package com.renewal.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.renewal.dto.MemberDTO;


@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession session;
	private String ns = "com.renewal.mapper.memberMapper";

	@Override
	public void register(MemberDTO dto) throws Exception {
		session.insert(ns+".insert", dto);
	}

	@Override
	public void update(int mNo) throws Exception {
	}

	@Override
	public void delete(int mNo) throws Exception {
	}
}
