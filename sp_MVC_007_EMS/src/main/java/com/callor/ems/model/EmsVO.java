package com.callor.ems.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
public class EmsVO {
	
	private long e_seq;
	private String e_from_email;
	
	@Email(message="Email형식이 아닙니다.")
	@NotEmpty(message = "받는사람 이메일은 반드시 입력하세요.")
	private String e_to_email;

	@Length(min = 1, max = 100, message="받는사람 이름은 한 글자부터 100글자까지만 가능")
	@NotNull(message = "보내는 사람 이름은 null값일 수 없습니다.")
	private String e_from_name;

	@NotEmpty(message = "받는사람 이름은 반드시 입력하세요.")
	private String e_to_name;
	
	@NotEmpty(message = "제목은 입력해야 합니다.")
	private String e_subject;
	private String e_content;
	
//	@Size(min = 1, max = 10, message="number는 1 부터 10 사이 값이어야 한다.")
	private String e_send_date;
	private String e_send_time;

//	@Min(value=1, message = "number는 1 보다 커야 한다.")
//	@Max(value=10, message = "number는 10 보다 작아야 한다.")
	private int num;
	
//	@DecimalMin(value="1", message="decimal은 10진수 1보타 커야한다.")
//	@DecimalMax(value="10", message="decimal은 10진수 10보다 작아야한다.")
	private int decimal;
	
//	@Pattern(regexp = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$")
	private String password;
	
}
