package com.callor.sec.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.callor.sec.model.UserVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service("authenticationProvider")
public class AuthorProviderImpl implements AuthenticationProvider{

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDeService;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		/* Authentication
		 * 로그인한 사용자의 정보를 전달받을 객체
		 * username password를 통한 login객체
		 * Princlple(username) Credential(password) 방식의 로그인
		 * */
		
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		
		UserVO user = (UserVO)userDeService.loadUserByUsername(username);
		/* 사용자의 비밀번호 검사를 실행해 정상접근인지 화긴
			최초 회원가입을 했을 땐 아직 정상 절차가 완료되지 않아 
			로그인 성공해도 다른 기능을 사용할 수 없도록 한다.
			다른 절차를 통해 정상 사용자임을 인증하면 다음번에는 true로 인가하느 절차이다.
		 */
		if(user.isEnabled() == false) {
			throw new BadCredentialsException(username + " 잘못된 접근입니다.");
		}
		log.debug("인증 class ");
		//인증 완료 되면 사용자 정보를 security.Context token 과 함께 담아 로그인 성공을 프로젝트에 
		Authentication authorOK = new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities());
													    //로그인한 사용자 정보, null,로그인한 사용자의 권한 리스트
		
		return authorOK;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return true;
	}
}
