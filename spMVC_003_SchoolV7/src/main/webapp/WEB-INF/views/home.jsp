<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME.JSP</title>
<style>
* {
	background-color: skyblue;
}

h4 {
	margin: 4px auto;
	background-color: white;
	text-align: center;
	margin: 20px 100px;
	padding: 20px;
	border-radius: 100px;
}

div a {
	border: 1px solid transparent;
	text-decoration: none;
	padding: 15px;
	background-color: blue;
	color: white;
	margin: 2px auto;
	border-radius: 10px;
}
.hello {
	text-align: center;
	margin: 100px;

}
div {
	margin-top: 100px;
}
</style>
<link rel="icon" href="${rootPath}/favicon.ico" type="image/x-icon" />
</head>
<body>
	<h4>회원가입 된 home 페이지</h4>
	<c:if test ="${empty USER}">
		<a href="${rootPath}/user/login" class="hello" >로그인하러 가자</a>
	</c:if>
	<c:if test ="${not empty USER}">
		<p class="hello">${USER.name} 님 반가워~</p>
		<a  href="${rootPath}/user/login">로그아웃하기</a>
	</c:if>
</body>
</html>