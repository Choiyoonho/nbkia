package com.renewal.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.renewal.dao.MemberDAO;
import com.renewal.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO dao;
	@Override
	public void register(MemberDTO dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public void update(int mNo) throws Exception {
	}

	@Override
	public void delete(int mNo) throws Exception {
	}
}
