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
}
