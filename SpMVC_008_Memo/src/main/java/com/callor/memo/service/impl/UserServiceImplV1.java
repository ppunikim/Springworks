package com.callor.memo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.memo.model.AuthorityVO;
import com.callor.memo.model.UserVO;
import com.callor.memo.service.UserService;

@Service
public class UserServiceImplV1 implements UserService{

	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(String VO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(UserVO vo) {
		// TODO Auto-generated method stub
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

	@Override
	public UserVO login(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorityVO> select_role(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
