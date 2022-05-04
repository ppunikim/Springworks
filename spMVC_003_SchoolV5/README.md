# Spring Mybatis Project
* SpringMVC Project 와 Oracle, MySQL 등 DBMS와 연동하는 Project

## Dependency 설정

### Spring-jdbc
* spring-jdbc 는 spring-webmvc와 ```version을 일치```시켜야 한다.
```
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
		<version>${org.springframework-version}</version>
		</dependency>
```
### mybatis
* 현재(2022-05-04) 3.5.9 최신 버전
```
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.9</version>
</dependency>
```
### mybatis-spring
* 현재 2.0.7 최신버젼
```
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>2.0.7</version>
</dependency>
```
### commons-dbcp2
* 현재 2.9.0 최신버젼
* DBMS와 연결할 때 Connection pool을 관리하는 도구
```
<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2 -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-dbcp2</artifactId>
    <version>2.9.0</version>
</dependency>
```

### ojdbc 또는 mysql-connector/j
* 각 DBMS Vender 별로 제공하는 JDBC
* Oracle 은 ```ojdbc8``` 을 사용하며 ```21.5.0.0``` 현재 사용
* maven repository 에서 ```Oracle``` 로 검색하기
```
<!-- https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc8 -->
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>21.5.0.0</version>
</dependency>
```
* mySQL Connection/J
* mysql은 DBMS 버젼에 따라 다른 Connector를 사용한다.
* 5.7.x 은 5.x.x. 를 사용하고, 8.x.x 는 현재 8.0.29를 사용한다.
```
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.29</version>
</dependency>
```