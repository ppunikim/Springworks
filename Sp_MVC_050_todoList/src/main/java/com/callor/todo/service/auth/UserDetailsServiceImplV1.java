package com.callor.todo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.todo.model.AuthorVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;

/*
 * Spring Security 에서 지원하는 UserDetailsService를 상속받아 클래스를 작성한다.
 */
@Service("userDetailsService")
public class UserDetailsServiceImplV1 implements UserDetailsService{

	private final UserDao userDao;
	
	public UserDetailsServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}
	
	// DB로부터 사용자 정보를 SELECT 해 사용자 정보가 있는지 검사하는 용도이다.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userDao.findById(username);
		// 사용자 정보가 DB에 없으면 밑의 정보를 나타내라.
		if(userVO == null) {
			throw new UsernameNotFoundException(username + " : 회원가입을 먼저하세요.");
		}

		List<AuthorVO> authos = userDao.select_auths(username);
		if(authos.size() < 1) {
			throw new UsernameNotFoundException(String.format("[%s] 아무런 권한이 없습니다. ",username));
		}
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		
		//사용자의 권한 정보를 문자열에서 GrantedAuthority 객체로 변환하기
		for(AuthorVO auth : authos) {
			grantList.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}
		userVO.setAuthorities(grantList);
		
		return userVO;
	}
	
	

}
