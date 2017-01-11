package org.springex01.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springex01.domain.UserVO;
import org.springex01.dto.LoginDTO;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	@Inject
	private SqlSession session;
	
	private static String ns = "org.springex01.mapper.UserMapper";
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return session.selectOne(ns+".login", dto);

	}
}
