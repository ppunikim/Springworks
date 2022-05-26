<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME.JSP</title>
<style>
* {
	background-color:skyblue;
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
	color:white;
	margin: 2px auto;
	border-radius: 10px;
}
div{
	margin-top: 100px;
}

</style>
<link rel="icon" href="${rootPath}/favicon.ico" type="image/x-icon" />
</head>
<body>
<h4>안녕 햇살아</h4>
<div><a href="${rootPath}/user/login">로그인하러 가자</a></div>
</body>
</html>