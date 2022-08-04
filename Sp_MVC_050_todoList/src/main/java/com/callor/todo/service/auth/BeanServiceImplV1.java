package com.callor.todo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.todo.persistance.UserDao;

@Service
public class BeanServiceImplV1 {

	
	@Autowired
	private UserDao userDao;

	
	// XML이 아닌 JavaClass에서 Bean 생성하기
	@Bean("passwordEncoder")
	public PasswordEncoder getPassword() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * UserServiceImpl에서 table을 생성하는 SQL을 호출하면
	 * 충돌해 별도 method를 분리해서 작성했다.
	 */
	@Bean
	public void create_table() {
		userDao.create_user_table();
		userDao.create_auth_table();
	}

}
