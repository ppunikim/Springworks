package com.callor.school.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.school.model.UserVO;
import com.callor.school.persistance.UserDao;
import com.callor.school.service.UserService;

/* UserServiceImplV1 클래스를 Component(bean)로 등록하기
 */

@Service
public class UserServiceImplV1 implements UserService {

	private final UserDao userDao;

	public UserServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserVO login(UserVO userVO) {
		String username = userVO.getUsername();
		String password = userVO.getPassword();
		if (username.equalsIgnoreCase("ppuni") && password.equals("12341234")) {
			userVO.setName("햇살");
			userVO.setRole("ADMIN");
			userVO.setEmail("yd62322@naver.com");
		} else {
			userVO = null;
		}

		return userVO;
	}// end login

	// TODO 회원가입 처리하기
	/*
	 * 1. 최초로 회원가입을 실행하는 가입자는 ADMIN role을 부여 
	 * 2. 두 번째 이후 회원가입을 실행하는 가입자는 USER role을 부여 
	 */
	@Override
	public UserVO join(UserVO userVO) {

		/* 1. user table에 데이터가 있는지 확인하기 위해 
		 * 전체 데이터를 select 하기
		 */
		List<UserVO> userList = userDao.selectAll();
		// 만약 user table에 데이터가 없으면 null을 return 한다.
		
		if(userList == null || userList.size() < 1) {
			//데이터가 없으면 최초 가입자이므로 role 권한을 admin(관리자)로 부여한다.
			userVO.setRole("ADMIN");
		} else {
			userVO.setRole("USER");
		}
		
		userDao.insert(userVO);
		return null;
	}// end join

	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	// TODO user service에게 toss만 하는 용도
	@Override
	public UserVO findById(String id) {
		return userDao.findById(id);
	}

	@Override
	public int insert(UserVO vo) {
		return 0;
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
