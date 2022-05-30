# Form 과 Button 관계

```
<form>
	<button type="submit">
</form>
```
* 위와 같은 form tag에 포함된 button은 기본적으로 type이 ```submit```이다.

* button type이 ```submit``` 인 경우 form tag에 포함된 input의 값을 무조건 서비스로 전송하는 event가 실행된다.

* 만약 버튼을 눌렀을 때 JS코드를 사용하여 상황을 제어하고 싶으면 버튼에 type을 ```button```으로 설정한다.

* button의 타입을 ```button```으로 설정하면 모양만 button이고 아무런 역할을 수행하지 못한다.

* button의 type에는 ```reset```도 있는데, 이 타입은 form tag에 포함된 input box데이터를 모두 제거한다.

## password 암호화 하기(5.30)
* spring-security-core 가져오기
```
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-core</artifactId>
    <version>5.3.13.RELEASE</version>
</dependency>
```
* spring/appServlet/security-context.xml파일 생성
```
<bean id="passwordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder">
		<constructor-arg index="0" value="4"/>
</bean>
```
* PasswordEncoder 를 상속받은 BCryptPasswordEncoder 클래스를 사용하여 bean 선언
* 이 때 생성자에 설정한 value값에 따라 내부에서 암호화 반복이 수행된다.
* 이 값은 4(기본값) 이상의 정수로 설정한다. 
* 하지만 너무 높게 설정하면 암호화에서 시간이 많이 소요된다.
