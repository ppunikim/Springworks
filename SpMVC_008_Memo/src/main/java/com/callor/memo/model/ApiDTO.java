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
@ToString
@Builder
public class ApiDTO {
	// 부산광역시 맛집정보 api를 이용하려한다.
	/* DTO : Data Transfer Object
	 * 역할은 VO와 같다.
	 */

	private String api; 

}
