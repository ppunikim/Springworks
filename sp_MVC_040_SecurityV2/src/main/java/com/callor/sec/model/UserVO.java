package com.callor.sec.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

/* Security에서 제공하는 사용자 정보를 담을 VO를 생성
 * 여기서 UserDetails인터페이스를 상속받아 사용한다
 * */
public class UserVO implements UserDetails{

	private String username;
	private String password;
	private boolean isAccountNotExpired;
	private boolean isAccountNotLocked;
	private boolean isCredentailsNotExpired;
	private Collection<? extends GrantedAuthority> authories;
}
