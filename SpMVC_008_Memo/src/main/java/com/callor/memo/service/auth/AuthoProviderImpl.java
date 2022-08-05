package com.callor.memo.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("authenticationProvider")
public class AuthoProviderImpl implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
						 //null 값 오류를 방지하기 위해 String으로 형변환해주기
		String username = (String)authentication.getPrincipal();	
		String password = (String)authentication.getCredentials();
		
		if(username.equals("ppunikim") == false) {
			throw new UsernameNotFoundException("아이디가 잘못되었습니다.");
		}
		if(password.equals("1234") == false) {
			throw new BadCredentialsException("비밀번호가 잘못되었습니다.");
		}
		List<GrantedAuthority> grantList = new ArrayList<>();

		grantList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		grantList.add(new SimpleGrantedAuthority("ROLE_USER"));

		//사용자 이름과 비번, 권한리스트로 token 발생
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(username, password, grantList);
		return token;
	
	}//end

	/*
	 * security에서 인증절차를 수행하기 위해 AuthencicationProvider를 상속받으면서
	 * 반드시 supports를 true로 만들어줘야 한다.
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
