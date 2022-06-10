package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.UserVO;
import com.callor.naver.persistance.UserDao;
import com.callor.naver.service.UserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service(QualifierConfig.SERVICE.USER_V1)
public class UserServiceImplV1 implements UserService{

	@Autowired
	protected UserDao userDao;
	
	@Autowired
	@Override
	public void create_user_table() {
		try {
			userDao.create_user_table();
			log.debug("USER TABLE OK");
		} catch (Exception e) {
			log.debug("USER TABLE CREATE ERROR!");
		}
	}
	
	@Override
	public List<UserVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findByNickName(String nickname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(String id) {
		return userDao.findById(id);
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
		UserVO loginUser = userDao.findById(userVO.getUsername());
		if(loginUser != null &&
			loginUser.getPassword().equals(userVO.getPassword())) {
				return loginUser;
			}
		return null;
	}	
	
	@Override
	public int join(UserVO userVO) {
		
		List<UserVO> users = userDao.selectAll();
		if(users == null || users.size() < 1) {
			userVO.setRole("ADMIN");
		} else {
			userVO.setRole("GUEST");
		}
		int ret = userDao.insert(userVO);
		return ret;
	}


}
