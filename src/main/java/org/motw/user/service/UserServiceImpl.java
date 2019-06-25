package org.motw.user.service;

import javax.annotation.Resource;

import org.motw.user.dao.UserDAO;
import org.motw.user.vo.UserVO;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	// 회원 가입
	@Override
	public int insertUser(UserVO userVO) throws Exception {
		return userDAO.insertUser(userVO);
	}
	
	// 아이디 중복확인
	@Override
	public int nameCheck(String username) throws Exception {
		return userDAO.nameCheck(username);
	}

	// 이메일 중복확인
	@Override
	public int emailCheck(String email) throws Exception {
		return userDAO.emailCheck(email);
	}
	
	
}
