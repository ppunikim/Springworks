# Spring MVC 프로젝트

## :cat:[Spring Mybatis Project](https://github.com/ppunikim/Springworks/tree/master/spMVC_003_SchoolV5)
* Spring 과 Mybatis 를 사용한 DBMS 연동 프로젝트
* 같이 저장을 해줘야 한다. 따로 하면 문제 생긴다.

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
