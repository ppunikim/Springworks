<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>나의 API APP</title>
<style>

</style>
<link rel="stylesheet"
	href="${rootPath}/static/css/main.css?ver=2022-06-02-002">
<link rel="stylesheet"
	href="${rootPath}/static/css/home.css?ver=2022-06-02-001">
<link rel="stylesheet"
	href="${rootPath}/static/css/table.css?ver=2022-06-02-001">
	
<link rel="stylesheet"
	href="${rootPath}/static/css/modal.css?ver=2022-05-31-002">
<link rel="stylesheet"
	href="${rootPath}/static/css/input.css?ver=2022-05-31-002">

<script>
	const rootPath = '${rootPath}'
</script>
<script src="${rootPath}/static/js/input.js?ver=2022-05-31-001"></script>
</head>
<% //rootpath는 이 프로젝트에서  naver를 말한다. %>
<body>
	<header>
		<h1>MY API</h1>
		<p>Naver API를 활용한 도서, 뉴스, 영화 정보 서비스</p>
	</header>
	<nav>
		<ul>
			<li><a href="${rootPath}/">Home</a></li>
			<li><a href="${rootPath}/books/list">도서정보</a></li>
			<li><a href="${rootPath}/news">오늘의 뉴스</a></li>
			<li><a href="${rootPath}/movies">영화정보</a></li>
			<li><a href="${rootPath}/naver">네이버 검색창</a></li>
 					<%  //a 태그는 컨트롤러에서 쓴다.  %>

			<% //로그인하지 않았을 때 %> 			
 			<c:if test="${empty MEMBER}" >
 			<li><a href="${rootPath}/member/login">로그인</a></li>
			<li><a href="${rootPath}/member/join">회원가입</a></li>
			</c:if>
			
			<% //로그인했을 때 = member객체에 로그인한 사용자 정보가 담겨있다. %> 			
			<c:if test="${not empty MEMBER}">
			<li><a href="${rootPath}/member/mypage">My Page</a></li>
			<li><a href="${rootPath}/member/logout">Logout</a></li>
			</c:if>
			
		</ul>
	</nav>
	<section class="main">
	
	</section>
	<footer>
		<address>CopyRight &copy;ppunikim</address>
	</footer>
	

</body>

</html>