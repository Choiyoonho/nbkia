package org.springex01.service;

import org.springex01.domain.UserVO;
import org.springex01.dto.LoginDTO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
}
