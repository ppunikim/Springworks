# spring 다시 복습

## 한글 엔코딩
```
	<filter>
		<filter-name>encKor</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>
			<param-value>true</param-value>
		</init-param>
	</filter>

	<filter-mapping>
		<filter-name>encKor</filter-name>
		<url-pattern>*</url-pattern>
	</filter-mapping>

```

## logback-text.xml에 적어줄 내용(콘솔에 필요한 것만 나오게 하기)
* git 에서 가져다 쓰면 logger의 name 부분은 바꿔줘야 한다.
```
<?xml version="1.0" encoding="UTF-8" ?>
<configuration scan="true" scanPeriod="3 seconds">

   <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <charset>UTF-8</charset>
            <Pattern>  [%-5level] %C{5} - %msg  %n</Pattern>
        </encoder>
    </appender>

    <logger name="org.springframework" level="INFO" />
    <logger name="com.callor.hello" level="DEBUG"  additivity="false">
        <appender-ref ref="STDOUT"/>
    </logger>

    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>

</configuration>
```
* 만약 level을 INFO로 바꾸면 console에 출력되지 않는다. 그냥 콘솔에 찍히는 내용을 보여주고 싶지 않을 때 하는 것이다.
```
 <logger name="com.callor.hello" level="INFO"  additivity="false">
 ```


## pom.xml에 적는 기초 세팅
* 콘솔에 많은 정보를 얻기 위해서 적어주는 것이다.
```
<!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.11</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
    <scope>provided</scope>
</dependency>
```

## servlet-context.xml
* web.xml이 바로 보는 것으로, base-package를 보는 것이다.
* 만약 base-package를 com.callor.hello로만 사용하면 spring이 너무 바빠진다.
* 매우 중요한 두 가지 package만 보도록 만들어 준 것이다.
```
	<context:component-scan base-package="com.callor.hello.controller" />
	<context:component-scan base-package="com.callor.hello.service.impl" />
```