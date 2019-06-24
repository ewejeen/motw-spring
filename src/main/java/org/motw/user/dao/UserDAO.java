package org.motw.user.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.motw.user.service.UserService;
import org.motw.user.vo.UserVO;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO implements UserService {

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "org.motw.mappers.userMapper";
	
	// 회원 가입
	@Override
	public int insertUser(UserVO userVO) throws Exception {
		return sqlSession.insert(NAMESPACE + ".insertUser", userVO);
	}
	
}
