package com.callor.school.exec;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/* 암호화 & 복호화
 * 평문을 보통으로 알아보기 힘든 특별한 문자열로 변환하여
 * 통신을 통해 전송하는 것을 "암호화" 라고 한다.
 * 또한 암호화된 특별한 문자열을 수신하여 다시 원래의 평문으로
 * 변환하는 것을 "복호화" 라고 한다.
 * 
 * 인가 : 보안과 관련된 용어로,
 * 정상적인 ID와 비밀번호를 사용하여 접속한 사용자에게
 * 데이터 접속을 허가하는 것.
 * 
 * 암호화의 방법
 * 1. 쌍방향 암호화
 *   -> 암호화화 복호화 기능이 같이 겸해서 사용하는 기법
 *   만약 비번을 암호화 한다면 
 *   회원가입에서 입력된 비번을 암호화 하여 테이블에 저장하고
 *   이후, 로그인을 시도하면 테이블에 저장된 비번을 다시 복호화 하여
 *   로그인 정보와 비교하는 것.
 *   
 *   중간에 key가 노출될 수 있고, 복호화 하는 코드가 공개될 경우 
 *   치명적인 보안 사고가 날 수 있다.
 *   
 *   쌍방향 암호화 기법의 단점을 보안한 것이 단방향 암호화 기법이다.
 * 2. 단방향 암호화 
 *   -> 암호화 기능은 존재하지만 복호화 가능이 없는 기법이다.
 *   화원가입을 할 때 입력된 비번을 암호화하여 table 에 저장하고
 *   이후 로그인을 시도하면
 *   입력된 비번을 다시 암호화 하여 table에 저장된 값과 비교한다.
 *   복호화 기능이 존재하지 않으므로
 *   암호화 할 때 사용한 기법이 노출되지 않고, 다소 안전하게
 *   작동할 수 있다.
 *   하지만 모든 것에 단점은 없는 법.: 암호화 하는 방법과 비교하는 방법을 
 *   같은 도구를 사용해야 하는 단점이 존재하기도 한다.
 */
public class CryptEx1 {
	public static void main(String[] args) {
		
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		
		String planText = "Republic of Korea";
		/* spring Security 프로젝트에서 제공하는
		 * BCryptPasswordEncoder를 사용하여
		 * 평문을 암호화 하기
		 * 코드 내부에서 자동으로 생성되는 salt key에 의해
		 * 암호화를 할 때마다 다른 값들이 추출된다.
		 * */
		String encText = bCrypt.encode(planText);
		System.out.println(encText);
		System.out.println("자릿수: "+ encText.length());
		
		
		
	}//end main
}//end class
