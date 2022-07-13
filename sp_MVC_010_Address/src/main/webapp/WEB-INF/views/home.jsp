<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>home.jsp</title>
</head>
<body>
	<h4>home이다.</h4>
	<form method="POST">
		<input name ="ad_name" placeholder="이름 적어라"/>
		<input name ="ad_tel" placeholder="전번 적어라"/>
		<input name ="ad_addr" placeholder="주소 적어라"/>
	</form>
</body>
</html>