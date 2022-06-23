<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>join_next</title>
</head>
<body>
	<form:form modelAttribute="userVO">
		<h1>회원가입</h1>
		<form:input path="email"/><br/>
		<form:input path="key" placeholder="인증키"/><br/>
		<c:if test="${not empty error}">
			<p>인증키가 잘못 되었습니다.</p>
		</c:if>
		
		<form:input path="username" placeholder="USER NAME"/><br/>
		<form:input path="password" type="password" placeholder="비밀번호를 입력하세요"/><br/>
		<input name="re_password" type="password" id="re_password" placeholder="비밀번호를 다시 입력하세요."/><br/>
		<form:input path="name" placeholder="이름을 입력하세요."/><br/>
		<button>회원가입</button>
	</form:form>	
</body>
</html>