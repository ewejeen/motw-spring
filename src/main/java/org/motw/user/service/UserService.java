package org.motw.user.service;

import org.motw.user.vo.UserVO;

public interface UserService {
	
	// 회원 가입
	int insertUser(UserVO userVO) throws Exception;

}
