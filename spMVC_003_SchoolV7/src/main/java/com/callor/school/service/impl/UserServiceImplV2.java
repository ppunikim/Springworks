package com.callor.school.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.school.model.UserVO;
import com.callor.school.persistance.UserDao;

/* UserServiceImplV1 클래스를 Component(bean)로 등록하기
 */

@Service("userServiceV2")
public class UserServiceImplV2 extends UserServiceImplV1{
	

	public UserServiceImplV2(UserDao userDao, PasswordEncoder pass) {
		super(userDao,pass);
	}

	@Override
	public UserVO login(UserVO userVO) {
	
		String username = userVO.getUsername();
		String password = userVO.getPassword();
		
		UserVO joinUserVO = userDao.findById(username);
		if(joinUserVO != null) {
			boolean bYes = pass.matches(password, joinUserVO.getPassword());
			if(bYes == false ) {
				return null;
			}
		}
		return joinUserVO;
	}// end login

}//end class
