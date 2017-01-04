package com.renewal.dao;

import com.renewal.dto.MemberDTO;

public interface MemberDAO {
	public void register(MemberDTO dto) throws Exception;
	public void update(int mNo) throws Exception;
	public void delete(int mNo) throws Exception;
}
