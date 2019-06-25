package org.motw.user.service;

import org.motw.user.vo.UserVO;

public interface UserService {
	
	// 회원 가입
	int insertUser(UserVO userVO) throws Exception;

	// 아이디 중복확인
	int nameCheck(String username) throws Exception;

	// 이메일 중복확인
	int emailCheck(String email) throws Exception;
}
