package com.callor.sec.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.sec.model.AuthorityVO;
import com.callor.sec.model.UserVO;
import com.callor.sec.persistance.UserDao;

/* Spring Security에서 로그인 사용자 정보를 DB로부터 
 * 가져와 핸들링 하는 클래스이다.
 * security UserDetailsService 인터페이스를 상속받고,
 * loadUserByUsername() method를 정의한다.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserDao userDao;
	public UserDetailsServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}


	//로그인한 사용자의 username 매개변수로 전달받아 
	//Dao를 통해 로그인한 사용자 정보를 DB로부터 가져온다.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userDao.findById(username);
		if(userVO == null) {
			// Spring security에게 강제로 exception을 발생시켜 메세지 전달하기
			throw new UsernameNotFoundException(username + " : 회원가입을 먼저해라.");
		}
		userVO.setEnabled(true);
		
		List<GrantedAuthority> authoList = new ArrayList<>();
		for(GrantedAuthority author : userVO.getAuthorities()) {
			authoList.add(new SimpleGrantedAuthority(author.toString()));
		}
		userVO.setAuthorities(authoList);
		return userVO;
	}//end UserDetails
	
}//end class
