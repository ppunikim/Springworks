package com.callor.hello.controller;

public class QualifyConfig {
	
	/*  ```정적 패턴```
	 *  이렇게 해주는 이유는, Service와 Controller에 각각 같은 내용을 매치하기 위해서이다.
	 *  이것은 클래스 명과 관련이 없다. 그와 관련된 것으로는 문자열 안의 내용이다.
	 *  또한 대소문자, 오타 구분을 잘 해주기 위해서이다.
	 */
	public final static String Home_Service_V1 = "homeV1";
	public final static String Home_Service_V2 = "hServiceV2";
	public final static String Home_Service_V3 = "homeServiceV3";
	
}
