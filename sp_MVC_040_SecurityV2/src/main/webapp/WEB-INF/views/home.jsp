<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
	* {
		padding : 0;
		margin: 0;
	}
	nav ul {
		list-style: none;
		display: flex;
		background-color: yellow;
		color: tomato;
	}
	nav li {
		padding: 12px 17px;
		margin: 5px;
		cursor: pointer;
	}
	nav li:hover {
		box-shadow: 2px 2px 2px tomato;
	}
	nav li:nth-of-type(2) {
		margin-left: auto
	}
	nav a {
		text-decoration: none;
		color:inherit;
	}
	logout-form {
		display: none;
	}
</style>
</head>
<body>
	<header class="w3-container w3-green w3=text-white">
		<h4>안녕</h4>
		<p>Simple Security Project</p>
	</header>
	<nav>
		<ul>
			<li><a href="${rootPath}/">HOME</a></li>
			<sec:authorize access="isAnonymous()">
				<li><a href="${rootPath}/user/login">login</a></li>
				<li><a href="${rootPath}/user/join">join</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
			<li class="logout">logout</li>
			<sec:authorize access="hasRole('ROLE_USER')">
				<li><a href="${rootPath}/user/mypage">myPage</a></li>
			</sec:authorize>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')" >
				<li><a href="${rootPath}/admain">관리자</a></li>
			</sec:authorize>
		</ul>
	</nav>
	
	<section class="w3-container w3-padding-16">
		<c:choose>
			<c:when test="${LAYOUT == 'LOGIN' }">
				<%@ include file="/WEB-INF/views/user/login.jsp" %>
			</c:when>
			<c:when test="${LAYOUT == 'JOIN' }">
				<%@ include file="/WEB-INF/views/user/join.jsp" %>
			</c:when>
			<c:otherwise>
				<h1>home 화면 입니다.</h1>
			</c:otherwise>
		</c:choose>
	</section>
	
	<form:form id="logout-form" action="${rootPath}/logout" method="POST" />
	<script>
		document.querySelector("li.logout")?.addEventListener("click",()=>{
			document.querySelector("form#logout-form")?.submit()
		})
	</script>



</body>
</html>