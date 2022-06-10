package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.UserVO;

@Service(QualifierConfig.SERVICE.USER_V2)
public class UserServiceImplV2 extends UserServiceImplV1{
	//password를 암호화 하는 곳이다.
	
	@Autowired
	protected PasswordEncoder passwordEncoder;
	
	@Override
	public int join(UserVO userVO) {
		
		List<UserVO> users = userDao.selectAll();
		if(users == null || users.size() < 1) {
			userVO.setRole("ADMIN");
		} else {
			userVO.setRole("GUEST");
		}
		String planPassword = userVO.getPassword();
		String encPassword = passwordEncoder.encode(planPassword);
		
		userVO.setPassword(encPassword);
		userDao.insert(userVO);
		return 0;
	}
	
	@Override
	public UserVO login(UserVO userVO) {

		UserVO loginUser = userDao.findById(userVO.getUsername());
		String encPassword = loginUser.getPassword();
		String planPassword = userVO.getPassword();
		if(passwordEncoder.matches(planPassword, encPassword)) {
			return loginUser;
		} else {
			return null;
		}
	}


}//end class
