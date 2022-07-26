# 성적처리 프로젝트
## thymeleaf 를 이용한 view 구현
* Spring에서 JSP가 아닌 html 파일 방식으로 화면 구현하기
* thymeleaf는 tag를 이용해 만든다.
* tag 내에 th:text라는 속성을 사용해 표현한다.
* 데이터를 표현하는데, 단축형을 지원해 좀더 간단한 코드를 사용할 수 있다.

## 기본 문법
* 데이터 표현하기 : th:text="${변수}"
* 반복문 표현하기 : th:each="요소 : ${리스트}"
* 변수 단축하기 : th:object=${변수} => 변수의 요소들 : `"*{요소}"`
* URL 표현하기 : th:href="@{주소}", th:src="@{주소}"
* rootPath : /*[[@{/}]]*/
* data 속성 : tr:attr="data-변수명=${값이 담긴 변수}"
* if문
```
<div th:if="${변수 == 3 }">
	여기는 변수 == 3 값이 true일때만 표현되는 부분
</div>
<span th:if="${변수.equals('재직중')}">
재직중
</span>
<span th:if="${변수 == 3}" th:text="${변수}"></span>
<span th:unless="${변수 == 4}" th:text="값 오류"></span>
```

## thymeleaf layout diaract
* thymeleaf templete을 사용해 layout구현하는 도구
* thymeleaf자체에서 지원하는 도구 없어 외부 도구 사용한다.
```
<!-- https://mvnrepository.com/artifact/nz.net.ultraq.thymeleaf/thymeleaf-layout-dialect -->
<dependency>
    <groupId>nz.net.ultraq.thymeleaf</groupId>
    <artifactId>thymeleaf-layout-dialect</artifactId>
    <version>3.1.0</version>
</dependency>
```

## thymeleaf 파일 연결하기
* th:include : 파일을 합성하여 완전히 한 파일로 생성, Controller에서 model에 담아 보낸 변수를 모두가 공유 가능
* th:insert : 현재 tag의 내부에 끼워넣기
* th:replace : 현재 tag를 지우고 대체하기