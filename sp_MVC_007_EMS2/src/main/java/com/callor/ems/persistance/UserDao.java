package com.callor.ems.persistance;

import com.callor.ems.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String>{

	public void create_user_table();
	
}
