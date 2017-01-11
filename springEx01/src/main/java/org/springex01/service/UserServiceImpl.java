package org.springex01.service;

import javax.inject.Inject;

import org.springex01.domain.UserVO;
import org.springex01.dto.LoginDTO;
import org.springex01.persistence.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Inject
	private UserDAO dao;

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}
}
