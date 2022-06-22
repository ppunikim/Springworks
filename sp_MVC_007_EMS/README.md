# EMS 프로젝트(Email Management System)
* >> 보안과 관련된 코드이므로, jasypt-context.xml을 주의깊게 보자!

## DBMS 연동
* mysql-connector-j;
* mybatis
* mybatis-spring
* spring-jdbc   ->  버젼 ${org.springframework-version} 로 바꿔줘야 한다.
* commons-dbcp

## 파일 업로드 도구
* commons-io
* commons-fileupload

## JSON 관련 도구
* jackson-bind

## 메일 전송 도구
* javaMail API(compat)
```
<!-- https://mvnrepository.com/artifact/javax.mail/mail -->
<dependency>
    <groupId>javax.mail</groupId>
    <artifactId>mail</artifactId>
    <version>1.4.7</version>
</dependency>
```

## 암호화 도구
* spring security core
``` 5.3.13 release ```
``` 회원가입 비번 암호화 도구 ```
* jasypt
```
<!-- https://mvnrepository.com/artifact/org.jasypt/jasypt -->
<dependency>
    <groupId>org.jasypt</groupId>
    <artifactId>jasypt</artifactId>
    <version>1.9.3</version>
</dependency>
```
``` 로그인 아이디 비번 암호화 도구 ```
``` 깃에도 올라가도 암호화로 인해 보이지 안도록 하는 것. ```
* jasypt-spring31 & JASYPT: Java Simplified Encryption
```
<!-- https://mvnrepository.com/artifact/org.jasypt/jasypt-spring31 -->
<dependency>
    <groupId>org.jasypt</groupId>
    <artifactId>jasypt-spring31</artifactId>
    <version>1.9.3</version>
</dependency>
```

## 데이터 유효성 검사 도구
``` 
서버(Controller) 단에서 데이터 유효성 검사 도구
```
* Bean validation api
```
<!-- https://mvnrepository.com/artifact/javax.validation/validation-api -->
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version>
</dependency>
```
* hibernate validator Engine
```
<!-- https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator -->
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.2.3.Final</version>
</dependency>
```
* spring context Support
```
<!-- https://mvnrepository.com/artifact/org.springframework/spring-context-support -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context-support</artifactId>
    <version>5.3.21</version>
</dependency>
```
```
Spring frameWork 5.x 버전에서는 서버단 유효성 검사를 위해 framework 관련 요소를 추가해 줘야 한다.
```
-------------------------------------
## MIME TYPE
* 인터넷을 통해 다양한 형태의 데이터를 보낼 때 서버와 웹브라우저, 클라이언트 간에 데이터의 형식을 지정하는 방식
* 일반적으로 html데이터는 text/html형식으로 기본값으로 설정되어있다.
* 만약 html 데이터를 text/plan 형식으로 보내면 웹브라우저에 html tag가 단순 문자열로 그대로 노출된다.
* MIME TYPE은 인터넷 환경이 발전할수록 계속 많아지고 더욱 다양해진다.
* 현재 주로 많이 사용하는 것은 text/html, image/jpg, video/mp4, audio/mp3, apploaction/json 등이 있다.
