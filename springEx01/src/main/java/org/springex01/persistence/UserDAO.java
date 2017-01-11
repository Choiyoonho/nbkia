package org.springex01.persistence;

import org.springex01.domain.UserVO;
import org.springex01.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
}
