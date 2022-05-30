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
header {
	padding: 1rem;
	text-align: center;
	color: black;
}
header h3 {
	background-color: white;
	border-radius: 10px;
	padding: 20px;
}
nav ul {
	list-style: none;
	color: inherit;
	display: flex;
}
nav li:nth-of-type(4) {
	margin-left: auto;
}
nav li {
	padding: 12px 1rem;
}
nav li:hover {
	background-color: #eee;
	cursor: pointer;
}
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/home.js?ver2022-05-30-001"></script>
<link rel="icon" href="${rootPath}/favicon.ico" type="image/x-icon" />
</head>
<body>
	<header>
		<h3>반가워</h3>	
	</header>
	<nav class="main_nav">
		<ul>
			<li>Home</li>
			<li>공지사항</li>
			<li>자유게시판</li>
			
			<c:choose>
				<c:when test="${empty USER}">
			<li>로그인</li>
			<li>회원가입</li>
				</c:when>
				<c:otherwise>
			<li>로그아웃</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
	
	
</body>
</html>



















