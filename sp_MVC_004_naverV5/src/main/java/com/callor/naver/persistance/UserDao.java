package com.callor.naver.persistance;

import java.util.List;

import com.callor.naver.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String>{
	
	public List<UserVO> findByName(String name);	//중복된 이름이 있을 수 있으므로
	public UserVO findByNickName(String nickname);
	public UserVO findByEmail(String email);	//email은 중복 불가능(Unique) 하도록
	
	public void create_user_table();
	
}//end UserDao
