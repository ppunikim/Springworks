package com.callor.memo.service;

import com.callor.memo.model.UserVO;
import com.callor.memo.persistance.UserDao;

public interface UserService extends UserDao{

	public UserVO login(UserVO userVO);

}