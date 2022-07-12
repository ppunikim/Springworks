package com.callor.hello.model;

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
public class AddressVO {
/* Data를 담아서 Method 사이에 전달하기 위한 중간 역할을 하는 것이다.
 *  ---즉, 물건 사기 직전의 장바구니 역할을 한다.
 * 만약 method에 전달해야 할 parameter, argument가 
 *  ---한개일 경우에는 변수에 담으면 되는데, 
 * 	---그것이 두 개 초과할 경우, 
 * 		 개별 변수로 선언하지 않고 VO, DTO 클래스를 선언해 그곳에 저장해 사용한다.
 * 
 * 이것은 실질적인 데이터 객체를 상징하는 중요한 개념이다.
 * 이곳에서는 private으로 선언해 밖에서 변경 불가능하게 만들고, 
 *  ---그 안에 내용을 채워넣을 getter, 내용을 가져올 setter를 통해 다른 클래스에서 접근한다.
 * 	---이것은 객체지향에서 정보 은닉, 캡슐화라고 한다.
 * 
 * 변수 명은 가급적 snake_case로 선언하는 것이 좋다. 
 *  ---이유는, 중요 변수와 이름 겹치지 않게 하기 위해
 */
	
	private String ad_name;
	private String ad_tel;
	private String ad_addr;
	
	
	
	
}
