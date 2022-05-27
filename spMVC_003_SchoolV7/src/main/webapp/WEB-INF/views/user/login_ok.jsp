<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실제로는 필요없지만 한번 만들어보는 페이지</title>
</head>
<body>

	<h3>${LOGIN.message}</h3>

	<c:choose>
		<c:when test="${LOGIN_MESSAGE == 'USERNAME FAIL'}">
			<h2>USER NAME(사용자 ID)가 없습니다.</h2>
			<a href="${rootPath}/user/login">로그인 다시하기</a>
		</c:when>
		<c:when test="${LOGIN_MESSAGE == 'PSSWORD FAIL'}">
			<h2>비밀번호가 잘못 되었습니다.</h2>
			<a href="${rootPath}/user/login">로그인 다시하기</a>
		</c:when>
		<c:otherwise>
			<c:if test="${not empty USER}">
				<h3>로그인 성공</h3>
				<p><b>USERNAME : </b>${USER.username}</p>
				<p><b>NAME : </b>${USER.name}</p>
				<p><b>email : </b>${USER.email}</p>
				<a href="${rootPath}/">홈으로</a>
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>