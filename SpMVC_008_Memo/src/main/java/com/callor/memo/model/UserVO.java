package com.callor.memo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserVO {
	private String username;
	private String password;
	private String email;
	private String realname;
	private String nickname;
	private String role;
}
