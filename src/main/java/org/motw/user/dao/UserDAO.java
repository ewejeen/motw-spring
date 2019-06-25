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
	
	private static final String NAMESPACE = "mappers.UserMapper";
	
	// 회원 가입
	@Override
	public int insertUser(UserVO userVO) throws Exception {
		return sqlSession.insert(NAMESPACE + ".insertUser", userVO);
	}
	
	// 아이디 중복확인
	@Override
	public int nameCheck(String username) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".nameCheck", username);
	}

	// 이메일 중복확인
	@Override
	public int emailCheck(String email) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".emailCheck", email);
	}
	
}
