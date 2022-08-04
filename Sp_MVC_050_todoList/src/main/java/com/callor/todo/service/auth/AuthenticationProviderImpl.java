package com.callor.todo.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.todo.model.UserVO;

@Service("authenticationProvider")
public class AuthenticationProviderImpl implements AuthenticationProvider{

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		/*
		 * UserDetailService 에서 username을 조회하여 DB table로부터 가져온 정보를 user객체에 받기
		 * 만약 username에 대한 데이터가 없으면 UserDetailService에서 exception이 발생하므로
		 * 더이상의 절차 없이 다시 로그인 화면으로 돌아간다.
		 */
		UserVO user = (UserVO) userService.loadUserByUsername(username);
		
		
		if(passwordEncoder.matches(password,user.getPassword()) == false) {
			throw new BadCredentialsException("비밀번호가 잘못 되었습니다. 다시 입력해");
		}
		
		// 관리자의 승인이 있어야만 회원가입이 가능하도록 하는 절차이다.
		if(user.isEnabled() == false) {
			throw new BadCredentialsException(username + " 은 회원가입 절차가 완료되지 않음");
		}
		
		//사용자가 정상적으로 로그인하면 인증 token 발행
		UsernamePasswordAuthenticationToken
			token = new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
		
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
}
